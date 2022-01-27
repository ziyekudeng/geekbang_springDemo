package com.example.geekbang.spring.class3.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@Value 没有注入预期的值
 * @author: gao wei
 * @create: 2022-01-25 09:19
 */

@RestController
@Slf4j
public class Example6StudentController {

    //@Value("#{student}")
    //private Student student;
    //
    //@Bean
    //public Student student() {
    //    Student student = createStudent(1, "xie");
    //    return student;
    //}
    //
    //private Student createStudent(int i, String xie) {
    //    return null;
    //}
    //
    //
    ////注册正常字符串
    //@Value("我是字符串")
    //private String text;
    //
    ////注入系统参数、环境变量或者配置文件中的值
    //@Value("${ip}")
    //private String ip;
    //
    ////注入其他Bean属性，其中student为bean的ID，name为其属性
    //@Value("#{student.name}")
    //private String name;
}
