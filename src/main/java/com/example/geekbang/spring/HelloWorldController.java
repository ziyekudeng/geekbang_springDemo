package com.example.geekbang.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_spring
 * @description: 案例 1：隐式扫描不到 Bean 的定义
 * @author: gao wei
 * @create: 2022-01-24 15:10
 */
@RestController
public class HelloWorldController {
    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi() {
        return "helloworld";
    }

}
