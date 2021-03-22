package com.yunjia.lark.config.security.authentication.handler.register;

import com.yunjia.lark.config.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * @Author myou
 * @Date 2021/3/22  2:38 下午
 * 加载自定义认证链路handler
 */

public class AuthenticationHandlerImport implements ImportSelector {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[0];
    }
}
