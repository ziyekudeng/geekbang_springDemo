package com.example.geekbang.spring.class20.example2.dbcontrol;

import java.lang.annotation.*;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * @author: gao wei
 * @create: 2022-02-09 15:06
 */

@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    String value();

    String core = "core";

    String card = "card";
}
