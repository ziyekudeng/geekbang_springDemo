package com.example.geekbang.spring.class15.example2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：ROLE_ 前缀与角色
 * @author: gao wei
 * @create: 2022-02-08 09:13
 */

@RestController
public class C15E2Controller {
    @RequestMapping(path = "/c15/e2/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin operation";
    }
}

