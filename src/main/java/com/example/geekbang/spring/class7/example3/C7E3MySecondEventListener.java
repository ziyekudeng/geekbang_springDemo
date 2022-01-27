package com.example.geekbang.spring.class7.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：部分事件监听器失效
 * @author: gao wei
 * @create: 2022-01-27 13:36
 */
@Component
@Order(2)
@Slf4j
public class C7E3MySecondEventListener implements ApplicationListener<C7E3MyEvent> {
    @Override
    public void onApplicationEvent(C7E3MyEvent event) {
        log.info("---------------------执行 C7E3MySecondEventListener 监听器-----------------------------------");
        log.info("{} received: {}", this.toString(), event);
        log.info("--------------------------------------------------------");

    }
}
