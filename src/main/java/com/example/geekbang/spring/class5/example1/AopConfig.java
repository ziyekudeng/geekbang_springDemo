package com.example.geekbang.spring.class5.example1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：this 调用的当前类方法无法被拦截
 * @author: gao wei
 * @create: 2022-01-26 10:27
 */

@Aspect
@Service
@Slf4j
public class AopConfig {
    @Around("execution(* com.example.geekbang.spring.class5.example1.ElectricService.pay()) ")
    public void recordPayPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Pay method time cost（ms）: " + (end - start));
    }
}
