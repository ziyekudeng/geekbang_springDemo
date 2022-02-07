package com.example.geekbang.spring.class12.example2;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-02-07 11:26
 */
@Data
public class C12E2Phone {
    @Size(max = 11)
    private String number;
}
