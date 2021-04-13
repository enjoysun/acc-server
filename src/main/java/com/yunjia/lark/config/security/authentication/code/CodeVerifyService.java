package com.yunjia.lark.config.security.authentication.code;

import com.yunjia.lark.util.EncryptorsKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


public interface CodeVerifyService {

    default boolean verifyCode(HttpServletRequest request, StringRedisTemplate redisTemplate) {
        String key = request.getHeader("username");
        String clientCode = request.getHeader("code");
        if (!StringUtils.isEmpty(key) && null != redisTemplate) {
            if (redisTemplate.hasKey(key)) {
                String code = redisTemplate.opsForValue().get(EncryptorsKey.hashString(key));
                if (StringUtils.equals(code, clientCode))
                    return true;
            }
        }
        return false;
    }

    default boolean setVerifyCodeExpire(String userName, String code, StringRedisTemplate redisTemplate) {
        redisTemplate.opsForValue().set(EncryptorsKey.hashString(userName), code, 60000, TimeUnit.MILLISECONDS);
        return true;
    }
}
