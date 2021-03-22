package com.yunjia.lark.config.security.authentication.handler;

import com.google.gson.Gson;
import com.yunjia.lark.config.SecurityProperties;
import com.yunjia.lark.util.EncryptorsKey;
import com.yunjia.lark.util.RedisService;
import com.yunjia.lark.util.rsa.impl.RSAProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author myou
 * @Date 2021/3/8  6:05 下午
 * security 未登录处理即匿名访问者处理
 * 进行401跳转处理
 * 构造response header:发布存储rsa密钥对的缓存key
 */
@Component
public class AnonymousAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SecurityProperties properties;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 根据访问ip进行密钥获取限制
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String remoteHost = httpServletRequest.getRemoteHost();
        // 允许跨域
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        // 允许自定义请求头token(允许head跨域)
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "token, Accept, Origin, X-Requested-With, Content-Type, Last-Modified");
        httpServletResponse.setHeader("Content-type", "application/json;charset=UTF-8");
        httpServletResponse.setHeader("WWW-Authenticate", String.format("Digest realm=%s", properties.getRealm()));
        if (StringUtils.isEmpty(remoteHost)){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.getWriter().print("验证信息不完整，无法颁发授权");
        }
        Long increment = RedisService.executeScript(redisTemplate, "script/lua/incr-expire.lua", Collections.singletonList(EncryptorsKey.interceptRsaKey(remoteHost)), Long.class, String.valueOf(properties.getIpFilterExpire()));
        if (null != increment && increment <= properties.getIpMaxApply()) {
            String rsaKey = EncryptorsKey.keyGenerators(); // 用于发布公钥的缓存key
            Map<String, String> secrets = RSAProvider.createKeys(1024);
            valueOperations.set(EncryptorsKey.rsaKey(rsaKey), new Gson().toJson(secrets), properties.getSecretExpire(), TimeUnit.MILLISECONDS);
            httpServletResponse.setHeader("public-key", secrets.get("publicKey"));
            httpServletResponse.setHeader("nonce", rsaKey);
            httpServletResponse.setHeader("qop", "auth");
            httpServletResponse.setHeader("algorithm", properties.getAlgorithm());
            httpServletResponse.sendRedirect(properties.getLoginUri());
            return;
        }
        httpServletResponse.sendRedirect(properties.getForbidden());
        return;
    }
}
