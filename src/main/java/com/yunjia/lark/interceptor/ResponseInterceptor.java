package com.yunjia.lark.interceptor;

import com.yunjia.lark.annotation.DefaultResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @description: ResponseInterceptor
 * @author: gyli
 * @date: 2021/1/11
 **/
public class ResponseInterceptor implements HandlerInterceptor {

    private static final String RESPONSE_DATA_REWRITE = "RESPONSE_DATA_REWRITE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(DefaultResponse.class)) {
                request.setAttribute(RESPONSE_DATA_REWRITE, clazz.getAnnotation(DefaultResponse.class));
            } else if (method.isAnnotationPresent(DefaultResponse.class)) {
                request.setAttribute(RESPONSE_DATA_REWRITE, method.getAnnotation(DefaultResponse.class));
            }
        }
        return true;
    }
}
