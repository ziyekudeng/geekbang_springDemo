package com.example.geekbang.spring.class16.example1;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：小心过滤器异常
 * @author: gao wei
 * @create: 2022-02-08 10:13
 */

@RestControllerAdvice
public class C16E1RestControllerAdvice {
    @ExceptionHandler(NotAllowException.class)
    @ResponseBody
    public String handle() {
        System.out.println("403");
        return "{\"resultCode\": 403}";
    }
}
