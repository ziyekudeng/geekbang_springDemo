package com.example.geekbang.spring.class22.example2.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：容易出错的 Mock
 * @author: gao wei
 * @create: 2022-02-10 09:24
 */
@SpringBootTest
public class C22E2ServiceOneTest extends C22E2ServiceTests{
    @Test
    public void test(){ System.out.println(c22E2ServiceOne); }
}
