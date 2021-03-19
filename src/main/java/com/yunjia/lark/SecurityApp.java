package com.yunjia.lark;

import com.yunjia.lark.config.SystemProperties;
import com.yunjia.lark.util.JWTUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 认证授权中心启动类
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan({"com.yunjia.lark.mapper"})
public class SecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class, args);
    }
}
