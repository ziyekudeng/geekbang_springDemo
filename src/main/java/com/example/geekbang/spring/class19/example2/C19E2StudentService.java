package com.example.geekbang.spring.class19.example2;

import com.example.geekbang.spring.class19.example1.C19E1Student;
import com.example.geekbang.spring.class19.example1.C19E1StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：试图给 private 方法添加事务
 * @author: gao wei
 * @create: 2022-02-09 13:13
 */


@Service
public class C19E2StudentService {
    @Autowired
    private C19E1StudentMapper studentMapper;

    @Autowired
    private C19E2StudentService c19E2StudentService;

    public void saveStudent(String realname) throws Exception {
        C19E1Student student = new C19E1Student();
        student.setRealname(realname);
        c19E2StudentService.doSaveStudent(student);
    }
    /*
     * 情况复现: 抛出异常但事务没有回滚
     * 方法被 private 修饰
     * 加了事务注解的方法，必须是调用被 Spring AOP 代理过的方法，也就是不能通过类的内部调用或者通过 this 的方式调用。
     */
    @Transactional
    public void doSaveStudent(C19E1Student student) throws Exception {
        studentMapper.saveStudent(student);
        if (student.getRealname().equals("小明")) {
            throw new RuntimeException("该用户已存在");
        }
    }
}

