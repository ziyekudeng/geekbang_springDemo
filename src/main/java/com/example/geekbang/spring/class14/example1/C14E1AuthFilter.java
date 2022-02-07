package com.example.geekbang.spring.class14.example1;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

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
//@Order(2)
@Slf4j
public class C14E1AuthFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        if (isPassAuth()) {
            System.out.println("通过授权");
            chain.doFilter(request, response);
        } else {
            System.out.println("未通过授权");
            ((HttpServletResponse) response).sendError(401);
        }
    }

    private boolean isPassAuth() throws InterruptedException {
        System.out.println("执行检查权限");
        Thread.sleep(1000);
        return true;
    }
}
