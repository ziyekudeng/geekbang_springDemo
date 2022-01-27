package com.example.geekbang.spring.class7.example3;

import org.springframework.context.ApplicationEvent;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：部分事件监听器失效
 * 答案: 最终事件的执行是由同一个线程按顺序来完成的，任何一个报错，都会导致后续的监听器执行不了。
 * @author: gao wei
 * @create: 2022-01-27 13:33
 */
public class C7E3MyEvent extends ApplicationEvent {
    public C7E3MyEvent(Object source) {
        super(source);
    }
}
