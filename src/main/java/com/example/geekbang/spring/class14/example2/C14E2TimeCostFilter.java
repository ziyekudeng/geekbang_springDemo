package com.example.geekbang.spring.class14.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：过滤器被多次执行
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */
/*
 *情况复现
 */
@WebFilter(urlPatterns = { "/c14/e2/*" })
@Order(1)
@Component
@Slf4j
public class C14E2TimeCostFilter implements Filter {
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
