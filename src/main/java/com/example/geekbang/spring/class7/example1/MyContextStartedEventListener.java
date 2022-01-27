package com.example.geekbang.spring.class7.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：试图处理并不会抛出的事件
 * @author: gao wei
 * @create: 2022-01-27 11:25
 */

@Slf4j
@Component
/*
 *问题出现
 */
//public class MyContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {


/*
 *修正方式: 把监听事件的类型修改成真正发生的事件
 */
public class MyContextStartedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        log.info("---------------------执行了MyContextStartedEventListener监听事件-----------------------------------");
        log.info("{} received: {}", this.toString(), event);
        log.info("--------------------------------------------------------");
    }

}
