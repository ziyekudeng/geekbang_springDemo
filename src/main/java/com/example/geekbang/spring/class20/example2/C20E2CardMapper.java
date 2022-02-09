package com.example.geekbang.spring.class20.example2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * @author: gao wei
 * @create: 2022-02-09 14:44
 */

@Mapper
public interface C20E2CardMapper {
    @Insert("INSERT INTO `card`(`student_id`, `balance`) VALUES (#{studentId}, #{balance})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveCard(C20E2Card card);
}
