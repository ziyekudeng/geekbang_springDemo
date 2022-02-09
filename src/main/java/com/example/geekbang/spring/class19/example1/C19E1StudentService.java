package com.example.geekbang.spring.class19.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：unchecked 异常与事务回滚
 * @author: gao wei
 * @create: 2022-02-09 13:13
 */

@Service
public class C19E1StudentService {
    @Autowired
    private C19E1StudentMapper c19E1StudentMapper;

    /*
     * 情况复现: 抛出异常但事务没有回滚
     * @Transactional
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(String realname) throws Exception {
        C19E1Student student = new C19E1Student();
        student.setRealname(realname);
        c19E1StudentMapper.saveStudent(student);
        if (student.getRealname().equals("小明")) {
            throw new Exception("该学生已存在");
        }
    }
}

