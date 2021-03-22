package com.yunjia.lark.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yunjia.lark.config.SystemProperties;
import com.yunjia.lark.model.reqvo.SysLoginUserVo;
import com.yunjia.lark.model.reqvo.SysUserReqVo;
import com.yunjia.lark.model.respvo.SysUserDetailRespVo;
import com.yunjia.lark.model.respvo.SysUserRespVo;
import com.yunjia.lark.model.system.RestResult;
import com.yunjia.lark.service.impl.SysUserServiceImpl;
import com.yunjia.lark.util.EncryptorsKey;
import com.yunjia.lark.util.JWTUtil;
import com.yunjia.lark.util.PropertiesCopy;
import com.yunjia.lark.util.RedisService;
import com.yunjia.lark.util.rsa.impl.RSAProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author myou
 * @Date 2021/3/18  2:47 下午
 */
@RestController
@RequestMapping("/user")
public class SysLoginController {

    private final Logger logger = LoggerFactory.getLogger(SysLoginController.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SystemProperties properties;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/sign-nonce")
    public RestResult signSecret() throws UnsupportedEncodingException {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String remoteHost = req.getRemoteHost();
        if (StringUtils.isEmpty(remoteHost)) {
            return new RestResult("400", null, "验证信息不完整，无法颁发授权");
        }
        Long increment = RedisService.executeScript(redisTemplate, "script/lua/incr-expire.lua", Collections.singletonList(EncryptorsKey.interceptRsaKey(remoteHost)), Long.class, String.valueOf(properties.getIpFilterExpire()));
        if (null != increment && increment <= properties.getIpMaxApply()) {
            String rsaKey = EncryptorsKey.keyGenerators(); // 用于发布公钥的缓存key
            Map<String, String> secrets = RSAProvider.createKeys(1024);
            logger.info(String.format("secrets key:%s", EncryptorsKey.rsaKey(rsaKey)));
            valueOperations.set(EncryptorsKey.rsaKey(rsaKey), new Gson().toJson(secrets), properties.getSecretExpire(), TimeUnit.MILLISECONDS);
            Map<String, String> map = new HashMap<>();
            map.put("nonce", rsaKey);
            map.put("public-key", secrets.get("publicKey"));
            return new RestResult("200", map, "success");
        }
        return new RestResult("403", null, "访问次数频繁");
    }

    @PostMapping("/register")
    public RestResult register(@RequestBody SysUserReqVo sysUserReqVo) throws InvalidKeySpecException, NoSuchAlgorithmException {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        RestResult restResult = verifyTicket(req);
        if (!restResult.getCode().equals("200")) {
            return restResult;
        }
        Ticket ticket = (Ticket) restResult.getData();
        SysUserRespVo checkStatus = sysUserService.queryByUserNameOrAccount(ticket.username);
        if (null != checkStatus) {
            return new RestResult("200", null, "已存在账户，请勿重复注册");
        }
        String privateKey = ticket.getSecrets().getOrDefault("privateKey", "");
        String decrypt = RSAProvider.privateDecrypt(ticket.getResponse(), RSAProvider.getPrivateKey(privateKey));
        String salt = EncryptorsKey.keyGenerators();
        String password = EncryptorsKey.hashString(EncryptorsKey.encryptors("MD5", salt, decrypt));
        sysUserReqVo.setPassword(password);
        sysUserReqVo.setAccount(ticket.username);
        sysUserReqVo.setSalt(salt);
        sysUserService.save(sysUserReqVo);
        SysUserDetailRespVo sysUserDetailRespVo = new SysUserDetailRespVo();
        sysUserDetailRespVo.setUserName(ticket.username);
        return new RestResult("200", jwtUtil.generateToken(sysUserDetailRespVo), "成功");
    }

    @PostMapping("/login")
    public RestResult login() throws InvalidKeySpecException, NoSuchAlgorithmException {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        RestResult restResult = verifyTicket(req);
        if (!restResult.getCode().equals("200")) {
            return restResult;
        }
        Ticket ticket = (Ticket) restResult.getData();
        String privateKey = ticket.getSecrets().getOrDefault("privateKey", "");
        String decrypt = RSAProvider.privateDecrypt(ticket.getResponse(), RSAProvider.getPrivateKey(privateKey));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(ticket.getUsername(), decrypt);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        Object principal = authenticate.getPrincipal();
        SysUserDetailRespVo sysUserDetailRespVo = new SysUserDetailRespVo();
        PropertiesCopy.copy(principal, sysUserDetailRespVo);
        return new RestResult("200", jwtUtil.generateToken(sysUserDetailRespVo), "成功");
    }

    private RestResult verifyTicket(HttpServletRequest req) {
        String nonce = req.getHeader("nonce");
        String username = req.getHeader("username");
        String response = req.getHeader("response");
        if (StringUtils.isEmpty(nonce) || StringUtils.isEmpty(username) || StringUtils.isEmpty(response)) {
            return new RestResult("400", null, "认证信息不完全");
        }
        Boolean hasKey = redisTemplate.hasKey(EncryptorsKey.rsaKey(nonce));
        if (null == hasKey || !hasKey) {
            return new RestResult("400", null, "认证超时");
        }
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String secret = operations.get(EncryptorsKey.rsaKey(nonce));
        Type type = new TypeToken<HashMap<String, String>>() {
        }.getType();
        HashMap<String, String> keyMap = new Gson().fromJson(secret, type);
        if (null == keyMap || keyMap.isEmpty()) {
            return new RestResult("400", null, "认证超时");
        }
        return new RestResult("200", Ticket.builder().nonce(nonce).username(username).response(response).secrets(keyMap).build(), "成功");
    }

    @Data
    @Builder
    @AllArgsConstructor
    private static class Ticket {
        private String nonce;
        private String username;
        private String response;
        private Map<String, String> secrets;
    }
}
