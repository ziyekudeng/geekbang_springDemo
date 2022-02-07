package com.example.geekbang.spring.class14.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：过滤器被多次执行
 * @author: gao wei
 * @create: 2022-02-07 11:52
 */
@Controller
@Slf4j
public class C14E2StudentController {
    @PostMapping("/c14/e2/regStudent/{name}")
    @ResponseBody
    public String saveUser(String name) throws Exception {
        System.out.println("用户注册成功");
        return "success";
    }
}
