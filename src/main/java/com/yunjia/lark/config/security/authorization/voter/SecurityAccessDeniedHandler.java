package com.yunjia.lark.config.security.authorization.voter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author myou
 * @Date 2021/3/8  6:09 下午
 * security 授权异常自定义处理
 *
 * 403验证
 */
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(403);
        httpServletResponse.getWriter().write(String.format("Forbidden:%s", e.getMessage()));
    }
}
