package com.yunjia.lark.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author myou
 * @Date 2021/3/18  2:32 下午
 */
@ConfigurationProperties(prefix = "acc")
public class SecurityProperties {
    private String realm;

    private String loginUri;

    private String forbidden;

    private long secretExpire;

    private long ipMaxApply;

    private String algorithm;

    private long ipFilterExpire;

    private String[] authenticationHandler;

    private String[] authorizationVoter;

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getLoginUri() {
        return loginUri;
    }

    public void setLoginUri(String loginUri) {
        this.loginUri = loginUri;
    }

    public String getForbidden() {
        return forbidden;
    }

    public void setForbidden(String forbidden) {
        this.forbidden = forbidden;
    }

    public long getSecretExpire() {
        return secretExpire;
    }

    public void setSecretExpire(long secretExpire) {
        this.secretExpire = secretExpire;
    }

    public long getIpMaxApply() {
        return ipMaxApply;
    }

    public void setIpMaxApply(long ipMaxApply) {
        this.ipMaxApply = ipMaxApply;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public long getIpFilterExpire() {
        return ipFilterExpire;
    }

    public void setIpFilterExpire(long ipFilterExpire) {
        this.ipFilterExpire = ipFilterExpire;
    }

    public String[] getAuthenticationHandler() {
        return authenticationHandler;
    }

    public void setAuthenticationHandler(String[] authenticationHandler) {
        this.authenticationHandler = authenticationHandler;
    }

    public String[] getAuthorizationVoter() {
        return authorizationVoter;
    }

    public void setAuthorizationVoter(String[] authorizationVoter) {
        this.authorizationVoter = authorizationVoter;
    }
}
