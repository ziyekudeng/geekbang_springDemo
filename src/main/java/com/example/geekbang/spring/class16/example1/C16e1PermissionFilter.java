package com.example.geekbang.spring.class16.example1;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：小心过滤器异常
 * @author: gao wei
 * @create: 2022-02-08 10:08
 */

//@WebFilter(urlPatterns = { "/c16/e1/*" })
//@Component
//public class C16e1PermissionFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        String token = httpServletRequest.getHeader("token");
//
//        if (!"111111".equals(token)) {
//            System.out.println("throw NotAllowException");
//            throw new NotAllowException();
//        }
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//
//}
