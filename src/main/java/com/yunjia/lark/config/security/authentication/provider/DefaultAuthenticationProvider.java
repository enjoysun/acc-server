package com.yunjia.lark.config.security.authentication.provider;

import com.yunjia.lark.service.impl.SysUserDetailServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

/**
 * @Author myou
 * @Date 2021/3/30  4:25 下午
 */
public class DefaultAuthenticationProvider {

    /*
     * 暂定初始化事项
     * */
    @Bean
    @ConditionalOnMissingBean(DaoAuthenticationProvider.class)
    public AuthenticationProvider defaultAuthenticationProvider(SysUserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        return daoAuthenticationProvider;
    }
}
