package com.example.geekbang.spring.class21.example3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：小心多次 URL Encoder
 * @author: gao wei
 * @create: 2022-02-09 17:49
 */

@RestController
public class C21E3Controller {
    @RequestMapping(path = "/c21/e3/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("para1") String para1){
        return "helloworld:" + para1 ;
    };
}
