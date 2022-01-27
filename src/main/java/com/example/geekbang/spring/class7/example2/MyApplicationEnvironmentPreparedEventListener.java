package com.example.geekbang.spring.class7.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：监听事件的体系不对
 * @author: gao wei
 * @create: 2022-01-27 12:48
 */

@Slf4j
@Component
public class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(final ApplicationEnvironmentPreparedEvent event) {
        log.info("---------------------执行了-----------------------------------");
        log.info("{} received: {}", this.toString(), event);
        log.info("--------------------------------------------------------");

    }

}
