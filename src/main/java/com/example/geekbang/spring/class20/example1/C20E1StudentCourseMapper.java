package com.example.geekbang.spring.class20.example1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：嵌套事务回滚错误
 * @author: gao wei
 * @create: 2022-02-09 13:56
 */

@Mapper
public interface C20E1StudentCourseMapper {
    @Insert("INSERT INTO `student_course`(`student_id`, `course_id`) VALUES (#{studentId}, #{courseId})")
    void saveStudentCourse(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);
}
