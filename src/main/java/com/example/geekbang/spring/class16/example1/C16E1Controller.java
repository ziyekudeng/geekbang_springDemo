package com.example.geekbang.spring.class16.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：小心过滤器异常
 * @author: gao wei
 * @create: 2022-02-08 09:56
 */

@Controller
@Slf4j
public class C16E1Controller {
    public C16E1Controller(){
        System.out.println("construct");
    }


    @PostMapping("/c16/e1/regStudent/{name}")
    @ResponseBody
    public String saveUser(String name) throws Exception {
        System.out.println("......用户注册成功");
        return "success";
    }
}
