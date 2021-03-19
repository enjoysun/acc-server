package com.yunjia.lark.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author myou
 * @Date 2021/3/18  2:32 下午
 */
@Data
@Component
public class SystemProperties {
    @Value("${ACC.digest-realm}")
    private String realm;

    @Value("${ACC.login-url}")
    private String loginUri;

    @Value("${ACC.forbidden}")
    private String forbidden;

    @Value("${ACC.secret-expire}")
    private long secretExpire;

    @Value("${ACC.secret-max-apply}")
    private long ipMaxApply;

    @Value("${ACC.algorithm}")
    private String algorithm;

    @Value("${ACC.ip-filter-expire}")
    private long ipFilterExpire;
}
