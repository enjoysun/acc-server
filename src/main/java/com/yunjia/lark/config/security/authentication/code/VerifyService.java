package com.yunjia.lark.config.security.authentication.code;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author myou
 * @Date 2021/4/14  7:03 下午
 */

/*验证码存储获取默认实现*/
public class VerifyService {

    private final static CodeVerifyService defaultVerifyService;

    static {
        defaultVerifyService = new VerifyService().new DefaultVerifyService();
    }

    private class DefaultVerifyService implements CodeVerifyService {

        @Override
        public boolean verifyCode(String userName, String clientCode, StringRedisTemplate redisTemplate) {
            return CodeVerifyService.super.verifyCode(userName, clientCode, redisTemplate);
        }

        @Override
        public boolean setVerifyCodeExpire(String userName, String code, StringRedisTemplate redisTemplate) {
            return CodeVerifyService.super.setVerifyCodeExpire(userName, code, redisTemplate);
        }
    }

    public static CodeVerifyService getDefaultVerifyServiceInstance() {
        return defaultVerifyService;
    }
}
