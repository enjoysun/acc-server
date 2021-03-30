package com.yunjia.lark.config.security.authentication.handler.register;


import com.yunjia.lark.config.SecurityProperties;
import com.yunjia.lark.config.security.authentication.provider.DefaultAuthenticationProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@EnableConfigurationProperties({SecurityProperties.class})
@Import({DefaultAuthenticationProvider.class, AuthenticationHandlerImport.class})
public @interface EnableAuthenticationHandler {
}
