package com.example.geekbang.spring.class19.example1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：unchecked 异常与事务回滚
 * @author: gao wei
 * @create: 2022-02-09 13:10
 */

@Mapper
public interface C19E1StudentMapper {
    @Insert("INSERT INTO `student`(`realname`) VALUES (#{realname})")
    void saveStudent(C19E1Student student);
}

