package com.example.geekbang.spring.class5.example2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：直接访问被拦截类的属性抛空指针异常
 * @author: gao wei
 * @create: 2022-01-27 09:44
 */
@Aspect
@Service
@Slf4j
public class AdminAopConfig {
    @Before("execution(* com.example.geekbang.spring.class5.example2.AdminUserService.login(..)) ")
    public void logAdminLogin(JoinPoint pjp) throws Throwable {
        System.out.println("! admin login ...");
    }
}
