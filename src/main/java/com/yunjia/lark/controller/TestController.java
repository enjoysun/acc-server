package com.yunjia.lark.controller;

import com.yunjia.lark.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TestController
 * @author: gyli
 * @date: 2021/3/4
 **/
@RestController
public class TestController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = "/test")
    public String test() {
        return "hello sequrity";
    }
}
