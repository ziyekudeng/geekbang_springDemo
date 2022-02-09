package com.example.geekbang.spring.class21.example1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：参数类型是 MultiValueMap
 * @author: gao wei
 * @create: 2022-02-09 17:49
 */

@RestController
public class C21E1Controller {
    @RequestMapping(path = "/c21/e1/hi", method = RequestMethod.POST)
    public String hi(@RequestParam("para1") String para1, @RequestParam("para2") String para2){
        return "helloworld:" + para1 + "," + para2;
    };
}
