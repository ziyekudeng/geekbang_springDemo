package com.example.geekbang.spring.class12.example3;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：嵌套校验失效
 * @author: gao wei
 * @create: 2022-02-07 09:57
 */
@Data
public class C12E3Student {
    @Size(min = 1, max = 10)
    @NotEmpty
    private String name;
    private short age;
    @Valid //开启级联校验
    private C12E3Phone phone;
}
