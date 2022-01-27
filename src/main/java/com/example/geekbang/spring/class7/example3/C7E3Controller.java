package com.example.geekbang.spring.class7.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：部分事件监听器失效
 * @author: gao wei
 * @create: 2022-01-27 13:40
 */

@RestController
@Slf4j
public class C7E3Controller {

    @Autowired
    private AbstractApplicationContext applicationContext;

    @RequestMapping(path = "c7/e3/publishEvent", method = RequestMethod.GET)
    public String notifyEvent(){
        log.info("---------------打印日志------------------------");
        log.info("start to publish event");
        applicationContext.publishEvent(new C7E3MyEvent(UUID.randomUUID()));
        return "ok";
    };
}
