package com.example.geekbang.spring.class20.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * @author: gao wei
 * @create: 2022-02-09 13:13
 */

@Service
public class C20E2StudentService {
    @Autowired
    private C20E2StudentService c20E2StudentService;
    @Autowired
    private C20E2CourseService c20E2CourseService;
    @Autowired
    private C20E2StudentMapper c20E2StudentMapper;
    @Autowired
    private C20E2CardService c20E2CardService;
    //省略非关键代码
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(String realname) throws Exception {
        C20E2Student student = new C20E2Student();
        student.setRealname(realname);
        int studentId = c20E2StudentService.doSaveStudent(student);
        try {
            c20E2CourseService.regCourse(studentId);
            c20E2CardService.createCard(studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Transactional
    public int doSaveStudent(C20E2Student student) throws Exception {
        int studentId = c20E2StudentMapper.saveStudent(student);
        return studentId;
    }
//省略非关键代码
}

