package com.yunjia.lark;

import com.yunjia.lark.config.security.authentication.handler.register.EnableAuthenticationHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 认证授权中心启动类
 */
@SpringBootApplication
@EnableSwagger2
@EnableAuthenticationHandler
@MapperScan({"com.yunjia.lark.mapper"})
public class SecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class, args);
    }
}
