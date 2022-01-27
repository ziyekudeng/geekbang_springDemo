package com.example.geekbang.spring.class7.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：试图处理并不会抛出的事件
 * @author: gao wei
 * @create: 2022-01-27 11:45
 */

@RestController
public class C7E2Controller {

    @Autowired
    private AbstractApplicationContext applicationContext;

    @RequestMapping(path = "c7/e2/publishEvent", method = RequestMethod.GET)
    public String notifyEvent(){
        applicationContext.start();
        return "ok";
    };
}
