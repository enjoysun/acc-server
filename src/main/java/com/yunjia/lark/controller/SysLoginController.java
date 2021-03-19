package com.yunjia.lark.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yunjia.lark.config.SystemProperties;
import com.yunjia.lark.model.reqvo.SysLoginUserVo;
import com.yunjia.lark.model.system.RestResult;
import com.yunjia.lark.util.EncryptorsKey;
import com.yunjia.lark.util.RedisService;
import com.yunjia.lark.util.rsa.impl.RSAProvider;
import org.apache.commons.lang3.StringUtils;
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

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SystemProperties properties;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/sign-nonce")
    public RestResult signSecret() throws UnsupportedEncodingException {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String remoteHost = req.getRemoteHost();
        remoteHost = StringUtils.isEmpty(remoteHost) ? "127.0.0.1" : remoteHost;
        Long increment = RedisService.executeScript(redisTemplate, "script/lua/incr-expire.lua", Collections.singletonList(EncryptorsKey.interceptRsaKey(remoteHost)), Long.class, String.valueOf(properties.getIpFilterExpire()));
        if (null != increment && increment <= properties.getIpMaxApply()) {
            String rsaKey = EncryptorsKey.keyGenerators(); // 用于发布公钥的缓存key
            Map<String, String> secrets = RSAProvider.createKeys(1024);
            System.out.println(EncryptorsKey.rsaKey(rsaKey));
            valueOperations.set(EncryptorsKey.rsaKey(rsaKey), new Gson().toJson(secrets), properties.getSecretExpire(), TimeUnit.MILLISECONDS);
            Map<String, String> map = new HashMap<>();
            map.put("nonce", rsaKey);
            map.put("public-key", secrets.get("publicKey"));
            return new RestResult("200", map, "success");
        }
        return new RestResult("403", null, "访问次数频繁");
    }

    @PostMapping("/register")
    public RestResult register() {
        return null;
    }

    @PostMapping("/login")
    public RestResult login() throws InvalidKeySpecException, NoSuchAlgorithmException {
        HttpServletRequest req = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
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
        String privateKey = keyMap.getOrDefault("privateKey", "");
        String decrypt = RSAProvider.privateDecrypt(response, RSAProvider.getPrivateKey(privateKey));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, decrypt);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        Object principal = authenticate.getPrincipal();
        return null;
    }
}
