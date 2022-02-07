package com.example.geekbang.spring.class12.example1;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：对象参数校验失效
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
public class C12E1Controller {
    /*
    *情况复现
     */
    @RequestMapping(path = "/c12/e1/students", method = RequestMethod.POST)
    public void addStudent(@RequestBody C12E1Student student){
        log.info("add new student: {}", student.toString());
        //省略业务代码
    }

    /*
    *修正方式一：标记 @Validated
     */
    @RequestMapping(path = "/c12/e1/students/1", method = RequestMethod.POST)
    public void addStudent1(@Validated @RequestBody C12E1Student student){
        log.info("add new student1: {}", student.toString());
        //省略业务代码
    }
    /*
     *修正方式二：标记 @Valid 关键字开头的注解
     */
    @RequestMapping(path = "/c12/e1/students/2", method = RequestMethod.POST)
    public void addStudent2(@Valid @RequestBody C12E1Student student){
        log.info("add new student2: {}", student.toString());
        //省略业务代码
    }
    /*
     *修正方式三：自定义一个以 Valid 关键字开头的注解
     */
    @RequestMapping(path = "/c12/e1/students/3", method = RequestMethod.POST)
    public void addStudent3(@ValidCustomized @RequestBody C12E1Student student){
        log.info("add new student3: {}", student.toString());
        //省略业务代码
    }
}
