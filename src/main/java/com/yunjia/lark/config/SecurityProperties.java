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

    /*digest摘要验证配置信息*/
    private String realm;

    /*前端登录页面路由*/
    private String loginUri;

    /*无权限跳转前端路由*/
    private String forbidden;

    /*认证非对称加密secret密钥有效时间*/
    private long secretExpire;

    /*nonce颁发非对称加密公钥接口单IP限制请求次数*/
    private long ipMaxApply;

    /*nonce摘要加密算法(默认也暂定MD5)*/
    private String algorithm;

    /*nonce颁发非对称加密公钥接口单IP限制时间段(目前存在时间段临界点问题，待改造为令牌桶算法进行限流)*/
    private long ipFilterExpire;

    /*认证链路配置，以全限定类名组成，多个链路以逗号进行分割*/
    private String[] authenticationHandler;

    /*访问控制链路配置，以全限定类名组成，多个链路以逗号进行分割*/
    private String[] authorizationVoter;

    public String getCodeHeader() {
        return codeHeader;
    }

    public void setCodeHeader(String codeHeader) {
        this.codeHeader = codeHeader;
    }

    /*认证配置(code码验证，传输在header的code键命名)*/
    private String codeHeader;

    public int getCodeDigit() {
        return codeDigit;
    }

    public void setCodeDigit(int codeDigit) {
        this.codeDigit = codeDigit;
    }

    /*认证配置(code码验证，定义验证的code码长度，不超过6位)*/
    private int codeDigit;

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
