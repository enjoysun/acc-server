package com.yunjia.lark.config.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.Authentication;

/**
 * @Author myou
 * @Date 2021/3/18  4:32 下午
 */
public class LoginFailEvent extends ApplicationEvent {
    public LoginFailEvent(Authentication authentication) {
        super(authentication);
    }
}
