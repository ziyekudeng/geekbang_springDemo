package com.example.geekbang.spring.class3.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：错乱的注入集合
 * @author: gao wei
 * @create: 2022-01-25 15:38
 */

@RestController
@Slf4j
public class Example7StudentController {

    private List<Student> students;

    public Example7StudentController(List<Student> students){
        this.students = students;
    }

    @RequestMapping(path = "students", method = RequestMethod.GET)
    public String listStudents(){
        return students.toString();
    };

}
