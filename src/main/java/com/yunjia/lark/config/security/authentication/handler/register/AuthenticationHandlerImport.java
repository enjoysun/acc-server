package com.yunjia.lark.config.security.authentication.handler.register;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author myou
 * @Date 2021/3/22  2:38 下午
 * 加载自定义认证链路handler
 */

public class AuthenticationHandlerImport implements DeferredImportSelector, EnvironmentAware {
    private Environment environment;


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String authenticationHandlers = this.environment.getProperty("ACC.authenticationHandler");
        if (!StringUtils.isEmpty(authenticationHandlers)) {
            return authenticationHandlers.split(",");
        }
        return new String[0];
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
