package com.example.geekbang.spring.class7.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：部分事件监听器失效
 * @author: gao wei
 * @create: 2022-01-27 13:34
 */
@Component
@Order(1)
@Slf4j
public class C7E3MyFirstEventListener implements ApplicationListener<C7E3MyEvent> {
    Random random = new Random();

    @Override
    public void onApplicationEvent(C7E3MyEvent event) {
        log.info("---------------------执行 C7E3MyFirstEventListener 监听器-----------------------------------");
        log.info("{} received: {}", this.toString(), event);
        log.info("--------------------------------------------------------");

        //模拟部分失效
        if (random.nextInt(10) % 2 == 1) {
            throw new RuntimeException("exception happen on first listener");
        }
    }


}
