package com.yunjia.lark.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TestController
 * @author: gyli
 * @date: 2021/3/4
 **/
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "hello sequrity";
    }
}
