package com.example.geekbang.spring.class20.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：嵌套事务回滚错误
 * @author: gao wei
 * @create: 2022-02-09 13:13
 */

@Service
public class C20E1StudentService {
    @Autowired
    private C20E1StudentService c20E1StudentService;
    @Autowired
    private C20E1CourseService c20E1CourseService;
    @Autowired
    private C20E1StudentMapper c20E1StudentMapper;

    //省略非关键代码
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(String realname) throws Exception {
        C20E1Student student = new C20E1Student();
        student.setRealname(realname);
        int studentId = c20E1StudentService.doSaveStudent(student);
        try {
            c20E1CourseService.regCourse(studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public int doSaveStudent(C20E1Student student) throws Exception {
        int studentId = c20E1StudentMapper.saveStudent(student);
        return studentId;
    }
//省略非关键代码
}

