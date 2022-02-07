package com.example.geekbang.spring.class13.example2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：Filter 中不小心多次执行 doFilter()
 * @author: gao wei
 * @create: 2022-02-07 11:49
 */

//@Component
@WebFilter(urlPatterns = { "/c13/e2/*" })
public class C13E2TimeCostFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //模拟异常
            System.out.println("Filter 处理中时发生异常");
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            /*
             *修正方式： 不管怎么调用过滤器，不能多次调用
             */
          //  chain.doFilter(request, response);
        }
        chain.doFilter(request, response);
    }
}
