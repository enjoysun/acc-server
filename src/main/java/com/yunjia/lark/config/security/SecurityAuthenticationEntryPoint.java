package com.yunjia.lark.config.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author myou
 * @Date 2021/3/8  6:05 下午
 * security 认证异常处理定义
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // 重定向或者日志和异常信息返回皆可在重写中处理
        httpServletResponse.getWriter().write(String.format("登录异常:%s", e.getMessage()));
    }
}
