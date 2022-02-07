package com.example.geekbang.spring.class12.example3;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：误解校验执行
 * @author: gao wei
 * @create: 2022-02-07 09:58
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@Validated
public class C12E3Controller {
    /*
    *情况复现
     */
    @RequestMapping(path = "/c12/e3/students", method = RequestMethod.POST)
    public void addStudent(@Valid @RequestBody C12E3Student student){
        log.info("案例3---add new student: {}", student.toString());
        //省略业务代码
    }

}
