package com.example.geekbang.spring.class20.example2.dbcontrol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * 这里要加上一个 @Order(1) 标记它的初始化顺序。这个 Order 值一定要比事务的 AOP 切面的值小，
 * 这样可以获得更高的优先级，否则自动切换数据源将会失效。
 * @author: gao wei
 * @create: 2022-02-09 15:07
 */

@Aspect
@Service
@Order(1)
public class DataSourceSwitch {
    @Around("execution(* com.example.geekbang.spring.class20.example2.C20E2CardService.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            MyDataSource.setDataSource(dataSource.value());
            System.out.println("数据源切换至：" + MyDataSource.getDatasource());
        }
        point.proceed();
        MyDataSource.clearDataSource();
        System.out.println("数据源已移除！");
    }
}
