package com.example.geekbang.spring.class12.example2;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：嵌套校验失效
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
public class C12E2Controller {
    /*
    *情况复现
     */
    @RequestMapping(path = "/c12/e2/students", method = RequestMethod.POST)
    public void addStudent(@Valid @RequestBody C12E2Student student){
        log.info("案例2---add new student: {}", student.toString());
        //省略业务代码
    }

}
