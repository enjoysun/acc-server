package com.yunjia.lark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证授权中心启动类
 */
@SpringBootApplication
@MapperScan({"com.yunjia.lark.mapper"})
public class SecurityApp {
    public static void main( String[] args ) {
        SpringApplication.run(SecurityApp.class, args);
    }
}
