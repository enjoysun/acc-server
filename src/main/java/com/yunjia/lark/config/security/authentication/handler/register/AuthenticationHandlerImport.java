package com.yunjia.lark.config.security.authentication.handler.register;

import com.yunjia.lark.config.security.authentication.provider.UserAndCodeAuthenticationProvider;
import com.yunjia.lark.config.security.authentication.provider.UserAuthenticationProvider;
import org.springframework.context.annotation.Bean;

import java.util.Set;

/**
 * @Author myou
 * @Date 2021/3/22  2:38 下午
 * 加载自定义认证链路handler
 */

public class AuthenticationHandlerImport {
    @Bean
    public UserAuthenticationProvider userAuthenticationProvider() {
        return new UserAuthenticationProvider();
    }

    @Bean
    public UserAndCodeAuthenticationProvider userAndCodeAuthenticationProvider() {
        return new UserAndCodeAuthenticationProvider();
    }
}
