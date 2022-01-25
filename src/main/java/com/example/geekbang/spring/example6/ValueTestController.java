package com.example.geekbang.spring.example6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@Value 没有注入预期的值
 * @author: gao wei
 * @create: 2022-01-25 15:13
 */

@RestController
@Slf4j
public class ValueTestController {
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${user.name1}")
    private String user_name;
    @Value("${user.password1}")
    private String pass_word;

    @RequestMapping(path = "user", method = RequestMethod.GET)
    public String getUser() {
        String str1 = "username:password=" + username + ":" + password;
        String str2 = "\n\r" +"user.name:user.password=" + user_name + ":" + pass_word;
        return str1 + "\n\r" + str2;
    }

    ;
}
