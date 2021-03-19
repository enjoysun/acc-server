package com.yunjia.lark.config.event.listener;

import com.yunjia.lark.config.event.LoginFailEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author myou
 * @Date 2021/3/18  4:33 下午
 */
@Component
public class LoginFailEventListener implements ApplicationListener<LoginFailEvent> {
    @Override
    public void onApplicationEvent(LoginFailEvent loginFailEvent) {
        System.out.println("登录失败需要做的事情");
    }
}
