package com.example.geekbang.spring.class13.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@WebFilter 过滤器无法被自动注入
 * @author: gao wei
 * @create: 2022-02-07 11:52
 */
@Controller
@Slf4j
public class C13E1StudentController {
    @PostMapping("/c13/e1/regStudent/{name}")
    @ResponseBody
    public String saveUser(String name) throws Exception {
        System.out.println("用户注册成功");
        return "success";
    }
}
