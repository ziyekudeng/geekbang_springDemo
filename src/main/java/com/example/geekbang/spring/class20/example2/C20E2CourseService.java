package com.example.geekbang.spring.class20.example2;

import com.example.geekbang.spring.class20.example1.C20E1CourseMapper;
import com.example.geekbang.spring.class20.example1.C20E1StudentCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：嵌套事务回滚错误
 * @author: gao wei
 * @create: 2022-02-09 14:01
 */

@Service
public class C20E2CourseService {
    @Autowired
    private C20E1CourseMapper c20E1CourseMapper;

    @Autowired
    private C20E1StudentCourseMapper c20E1StudentCourseMapper;


    /*
    *注意这个方法标记了“Transactional”
    * 情况复现,嵌套事务回滚: @Transactional(rollbackFor = Exception.class)
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void regCourse(int studentId) throws Exception {
        c20E1StudentCourseMapper.saveStudentCourse(studentId, 1);
        c20E1CourseMapper.addCourseNumber(1);
    }
}

