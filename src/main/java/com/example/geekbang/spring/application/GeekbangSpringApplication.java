package com.example.geekbang.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("com.example.geekbang.spring.class*.*")
@EnableAspectJAutoProxy(exposeProxy = true)
public class GeekbangSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GeekbangSpringApplication.class, args);
        /*
         *服务完整运行后停止
         */
        //context.close();
    }

}
