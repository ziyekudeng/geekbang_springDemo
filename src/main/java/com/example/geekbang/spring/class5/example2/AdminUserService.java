package com.example.geekbang.spring.class5.example2;

import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：直接访问被拦截类的属性抛空指针异常
 * @author: gao wei
 * @create: 2022-01-27 09:41
 */

@Service
public class AdminUserService {
    public final User adminUser = new User("202101166");

    public void login() {
        System.out.println("admin user login...");
    }
    /*
     *修正方式一
     */

    public User getAdminUser() {
        return adminUser;
    }
    /*
    *修正方式二: 修改启动参数 spring.objenesis.ignor = true 初始化代理类的属性
     */
}
