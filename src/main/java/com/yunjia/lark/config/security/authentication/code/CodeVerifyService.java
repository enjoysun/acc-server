package com.yunjia.lark.config.security.authentication.code;

import com.yunjia.lark.util.EncryptorsKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;


public interface CodeVerifyService {

    default boolean verifyCode(String userName, String clientCode, StringRedisTemplate redisTemplate) {
        if (!StringUtils.isEmpty(userName) && null != redisTemplate) {
            if (redisTemplate.hasKey(userName)) {
                String code = redisTemplate.opsForValue().get(EncryptorsKey.hashString(userName));
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
