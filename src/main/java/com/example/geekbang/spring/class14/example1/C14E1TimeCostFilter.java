package com.example.geekbang.spring.class14.example1;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：@WebFilter 过滤器使用 @Order 无效
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */
/*
 *情况复现
 */
//@WebFilter(urlPatterns = { "/c14/e1/*" })
//@Order(1)
@Slf4j
public class C14E1TimeCostFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("#开始计算接口耗时");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("#执行时间(ms)：" + time);
    }
}
