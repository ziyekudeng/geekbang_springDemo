package com.example.geekbang.spring.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: geekbang_springDemo
 * @description: 案例2 问题修正
 * @author: gao wei
 * @create: 2022-01-24 17:09
 */
@Configuration
public class ServiceBeanConfig {
    /*
     *@Configuration注解作用
     *表明一个类中声明一个和多个@Bean标记的方法，并且这些方法被Spring容器管理用于生成Bean定义以及在运行时这些Bean的服务请求。
     */
    //这个bean装配给ServiceImpl的构造器参数“serviceName”
    @Bean
    public String serviceName() {
        return "MyServiceName";
    }
}
