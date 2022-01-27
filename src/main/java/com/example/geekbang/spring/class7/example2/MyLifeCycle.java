package com.example.geekbang.spring.class7.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：错乱混合不同类型的增强
 * @author: gao wei
 * @create: 2022-01-27 12:44
 */

@Component
@Slf4j
public class MyLifeCycle implements Lifecycle {

    private volatile boolean running = false;

    @Override
    public void start() {
        log.info("---------------------MyLifeCycle.start-----------------------------------");
        log.info("lifecycle start");
        log.info("--------------------------------------------------------");
        running = true;
    }

    @Override
    public void stop() {
        log.info("---------------------MyLifeCycle.stop-----------------------------------");
        log.info("lifecycle stop");
        log.info("--------------------------------------------------------");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

}
