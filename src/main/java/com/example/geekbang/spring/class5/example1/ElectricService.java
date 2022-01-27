package com.example.geekbang.spring.class5.example1;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：this 调用的当前类方法无法被拦截
 * 原因：
 * JDK 动态代理只能对实现了接口的类生成代理，而不能针对普通类。
 * CGLIB 是可以针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，来实现代理对象。
 * 重点: 只有引用的是被动态代理创建出来的对象，才会被 Spring 增强，具备 AOP 该有的功能。
 * @author: gao wei
 * @create: 2022-01-26 10:25
 */

@Service
public class ElectricService {
    //@Autowired
    //private ElectricService electricService;

    public void charge() throws Exception {
        System.out.println("Electric charging ...");
        /*
         *问题复现
         */
//        this.pay();
        /*
         *修正方式一
         */
       // electricService.pay();
        /*
         *问题修正方式二
         */
        //修改 EnableAspectJAutoProxy 注解的 exposeProxy 属性
        ElectricService electric = ((ElectricService) AopContext.currentProxy());
        electric.pay();
    }

    public void pay() throws Exception {
        System.out.println("Pay with alipay ...");
        Thread.sleep(1000);
    }

}
