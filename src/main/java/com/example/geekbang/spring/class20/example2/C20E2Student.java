package com.example.geekbang.spring.class20.example2;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：unchecked 异常与事务回滚
 * @author: gao wei
 * @create: 2022-02-09 13:09
 */
@Data
public class C20E2Student implements Serializable {
    private Integer id;
    private String realname;
}
