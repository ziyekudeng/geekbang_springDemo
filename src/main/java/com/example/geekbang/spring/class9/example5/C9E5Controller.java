package com.example.geekbang.spring.class9.example5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @program: geekbang_springDemo
 * @description: 思考题
 * @author: gao wei
 * @create: 2022-01-27 15:38
 */

@RestController
@Slf4j
public class C9E5Controller {


    @RequestMapping(path = "/c9/e5/hi2", method = RequestMethod.GET)
    public String hi2(@RequestParam("name") String[] name){
        return Arrays.toString(name);
    };
}
