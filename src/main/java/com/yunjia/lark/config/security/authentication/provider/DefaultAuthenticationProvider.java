package com.yunjia.lark.config.security.authentication.provider;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author myou
 * @Date 2021/3/30  4:25 下午
 */
public class DefaultAuthenticationProvider implements DeferredImportSelector, EnvironmentAware {

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
