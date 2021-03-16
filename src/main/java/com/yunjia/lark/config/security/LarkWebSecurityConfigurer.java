package com.yunjia.lark.config.security;

import com.yunjia.lark.util.SeedIncubator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/**
 * @Author myou
 * @Date 2021/3/9  10:52 上午
 */
@Configuration
@EnableWebSecurity
public class LarkWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Value("${ACC.ReadmName}")
    private String ReadmName;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated().and()
                .addFilter(digestAuthenticationFilter())
                .exceptionHandling().authenticationEntryPoint(entryPoint())
                .and()
                .csrf().disable();
    }

    @Bean
    public DigestAuthenticationEntryPoint entryPoint() {
        DigestAuthenticationEntryPoint entryPoint = new DigestAuthenticationEntryPoint();
        entryPoint.setRealmName(this.ReadmName);
        entryPoint.setKey(SeedIncubator.seedSign());
        return entryPoint;
    }

    @Bean
    public DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter result = new DigestAuthenticationFilter();
        result.setUserDetailsService(null);
        result.setAuthenticationEntryPoint(entryPoint());
        return result;
    }
}
