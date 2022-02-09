package com.example.geekbang.spring.class21.example2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：当 URL 中含有特殊字符
 * @author: gao wei
 * @create: 2022-02-09 17:49
 */

@RestController
public class C21E2Controller {
    @RequestMapping(path = "/c21/e2/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("para1") String para1){
        return "helloworld:" + para1 ;
    };
}
