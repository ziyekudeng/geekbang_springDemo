package com.example.geekbang.spring.class13.example2;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：Filter 中不小心多次执行 doFilter()
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */

@Component
public class C13E2TimeCostFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //模拟异常
            System.out.println("Filter 处理中时发生异常");
            throw new RuntimeException();
        } catch (Exception e) {
            chain.doFilter(request, response);
        }
        chain.doFilter(request, response);
    }
}
