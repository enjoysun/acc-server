package com.yunjia.lark.config.security.authorization.voter;

import com.yunjia.lark.config.security.authorization.service.AuthorizationService;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import java.util.Collection;

/**
 * @Author myou
 * @Date 2021/3/31  4:58 下午
 */
public class AuthenticatedVoter implements AccessDecisionVoter {

    private AuthorizationService authorizationService;

    public AuthenticatedVoter(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public int vote(Authentication authentication, Object o, Collection collection) {
        return authorizationService.grant(authentication, o, collection);
    }

    @Override
    public boolean supports(Class aClass) {
        return true;
    }
}
