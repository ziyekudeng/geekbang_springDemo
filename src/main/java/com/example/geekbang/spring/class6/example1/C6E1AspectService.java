package com.example.geekbang.spring.class6.example1;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：错乱混合不同类型的增强
 * @author: gao wei
 * @create: 2022-01-27 10:36
 */

//省略 imports
@Aspect
@Service
@Slf4j
public class C6E1AspectService {
    /*
    *切面注解排序: 依次为 Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class
     */
    @Before("execution(* com.example.geekbang.spring.class6.example1.C6E1ElectricService.charge()) ")
    public void checkAuthority(JoinPoint pjp) throws Throwable {
        System.out.println("validating user authority");
        Thread.sleep(1000);
    }

    @Around("execution(* com.example.geekbang.spring.class6.example1.C6E1ElectricService.doCharge()) ")
    public void recordPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("charge method time cost: " + (end - start) + "ms");
    }
}
