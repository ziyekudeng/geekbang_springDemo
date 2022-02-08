package com.example.geekbang.spring.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("com.example.geekbang.spring.class*.*")
@EnableAspectJAutoProxy(exposeProxy = true)
@ServletComponentScan("com.example.geekbang.spring.class*.*")
@Slf4j
//Class 15
public class GeekbangSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GeekbangSpringApplication.class, args);
        log.info("启动成功");
        /*
         *服务完整运行后停止
         */
        //context.close();
        //log.info("服务完整运行后停止");
    }

}
