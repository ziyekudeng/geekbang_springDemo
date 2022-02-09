package com.example.geekbang.spring.class20.example2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：unchecked 异常与事务回滚
 * @author: gao wei
 * @create: 2022-02-09 13:10
 */

@Mapper
public interface C20E2StudentMapper {
    @Insert("INSERT INTO `student`(`realname`) VALUES (#{realname})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int saveStudent(C20E2Student student);
}

