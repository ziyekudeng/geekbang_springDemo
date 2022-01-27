package com.example.geekbang.spring.class5.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：this 调用的当前类方法无法被拦截
 * @author: gao wei
 * @create: 2022-01-26 17:15
 */

@RestController
public class ElectricController {
    @Autowired
    ElectricService electricService;

    @RequestMapping(path = "charge", method = RequestMethod.GET)
    public void charge() throws Exception {
        electricService.charge();
    }

    ;
}
