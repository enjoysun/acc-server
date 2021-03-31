package com.yunjia.lark.config.security.authorization.service;

import org.springframework.security.core.Authentication;

import java.util.Collection;

/*
* 访问控制检查抽象
* */
public interface AuthorizationService {
    /*
    * 授权是否通过
    *int ACCESS_GRANTED = 1;
    *int ACCESS_ABSTAIN = 0;
    *int ACCESS_DENIED = -1;
    * */
    int grant(Authentication authentication, Object object, Collection collection);
}
