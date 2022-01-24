package com.example.geekbang.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.geekbang.spring.controller")
public class GeekbangSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeekbangSpringApplication.class, args);
    }

}
