package com.example.geekbang.spring.class5.example2;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：直接访问被拦截类的属性抛空指针异常
 * @author: gao wei
 * @create: 2022-01-27 09:40
 */

public class User {
    private String payNum;
    public User(String payNum) {
        this.payNum = payNum;
    }
    public String getPayNum() {
        return payNum;
    }
    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }
}
