package com.yunjia.lark.config.security.authentication.handler.register;

import com.yunjia.lark.config.security.authentication.provider.DefaultAuthenticationProvider;
import com.yunjia.lark.service.impl.SysUserDetailServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

/**
 * @Author myou
 * @Date 2021/3/22  2:38 下午
 * 加载自定义认证链路handler
 */

public class AuthenticationHandlerImport {
    /*
     * 暂定初始化事项
     * */
    @Bean
    @ConditionalOnMissingBean(DefaultAuthenticationProvider.class)
    public AuthenticationProvider defaultAuthenticationProvider(SysUserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        return daoAuthenticationProvider;
    }
}
