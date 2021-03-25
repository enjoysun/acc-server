package com.yunjia.lark.config.security.authentication;

import com.yunjia.lark.config.security.authentication.handler.AnonymousAuthenticationEntryPointHandler;
import com.yunjia.lark.config.security.authentication.handler.LoginFailureHandler;
import com.yunjia.lark.config.security.authentication.provider.UserAndCodeAuthenticationProvider;
import com.yunjia.lark.config.security.authentication.provider.UserAuthenticationProvider;
import com.yunjia.lark.service.impl.SysUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author myou
 * @Date 2021/3/9  10:52 上午
 */
@Configuration
@EnableWebSecurity
public class LarkWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserDetailServiceImpl userDetailService;

    @Autowired
    private AnonymousAuthenticationEntryPointHandler anonymousAuthenticationEntryPointHandler;

    @Autowired
    public UserAuthenticationProvider userAuthenticationProvider;

    @Autowired
    public UserAndCodeAuthenticationProvider userAndCodeAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider);
//        auth.userDetailsService(userDetailService)
//                .and() //自定义认证provider添加
//                .authenticationProvider(userAuthenticationProvider());
//                .authenticationProvider(userAndCodeAuthenticationProvider());
        /*关于配置AuthenticationProvider认证链路问题:
         * 存在一个默认的DaoAuthenticationProvider认证provider，这个provider是在该方法中配置userDetailService时，自动加入providerManager管理的provider列表中
         * providerManager中认证逻辑是多个provider进行链路认证，只要有一个provider返回Authentication则代表认证成功，若所有的provider返回null则，认证失败
         * 本系统想主动构造provider进行认证逻辑自定义，所以无需要默认的provider，而providerManager的list<Providers>属性属于外部不可访问，无法进行remove所以取消AuthenticationManagerBuilder中配置provider
         * 转为在HttpSecurity中配置provider
         * 详情见:https://github.com/spring-projects/spring-security/issues/4149
         * */
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * 静态资源放行
     **/
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();

        // 取消spring的session机制
        http.authorizeRequests()
                // 放行接口
                // 暴露关于token操作接口
                .antMatchers("/login.html").permitAll()
                .antMatchers("/forbidden.html").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/user/**").permitAll()
                // 页面按照权限进行访问限制
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/test/**").permitAll()
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()
                // 异常处理(权限拒绝、登录失效等)
                .and().exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationEntryPointHandler); //匿名用户访问无权限资源时颁发密钥和401处理
//                .accessDeniedHandler(accessDeniedHandler)//登录用户没有权限访问资源
//                // 登入
//                .and().formLogin().permitAll()//允许所有用户
//                .successHandler(loginSuccessHandler)//登录成功处理逻辑
//                .failureHandler(loginFailureHandler)//登录失败处理逻辑
//                // 登出
//                .and().logout().permitAll()//允许所有用户
//                .logoutSuccessHandler(logoutSuccessHandler)//登出成功处理逻辑
//                .deleteCookies(RestHttpSessionIdResolver.AUTH_TOKEN)
//                // 会话管理
//                .and().sessionManagement().invalidSessionStrategy(invalidSessionHandler) // 超时处理
//                .maximumSessions(1)//同一账号同时登录最大用户数
//                .expiredSessionStrategy(sessionInformationExpiredHandler); // 顶号处理
    }


    // 跨域配置(WebSecurityHttp也需要支持cors().and())
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration cors = new CorsConfiguration();
        cors.setAllowCredentials(true);
        cors.addAllowedOrigin("*");
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", cors);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
