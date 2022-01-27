package com.example.geekbang.spring.class4.example3.example21;

import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：构造器内抛空指针异常
 * @author: gao wei
 * @create: 2022-01-25 16:16
 */

@Service
public class LightService {
    public void start() {
        System.out.println("turn on all lights");
    }
    public void shutdown() {
        System.out.println("turn off all lights");
    }
    public void check() {
        System.out.println("check all lights");
    }
}
