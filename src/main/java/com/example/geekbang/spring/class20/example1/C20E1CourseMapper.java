package com.example.geekbang.spring.class20.example1;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：嵌套事务回滚错误
 * @author: gao wei
 * @create: 2022-02-09 13:57
 */

@Mapper
public interface C20E1CourseMapper {
    @Update("update `course` set number = number + 1 where id = #{id}")
    void addCourseNumber(int courseId);
}
