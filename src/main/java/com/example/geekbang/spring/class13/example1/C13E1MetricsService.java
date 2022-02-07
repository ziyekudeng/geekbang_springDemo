package com.example.geekbang.spring.class13.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@WebFilter 过滤器无法被自动注入
 * @author: gao wei
 * @create: 2022-02-07 11:57
 */
@Service
public class C13E1MetricsService {

    /*
     *修正方式
     */
    @Autowired
    @Qualifier("com.example.geekbang.spring.class13.example1.C13E1TimeCostFilter")
    public FilterRegistrationBean c13E1TimeCostFilter;
    //省略其他非关键代码
}
