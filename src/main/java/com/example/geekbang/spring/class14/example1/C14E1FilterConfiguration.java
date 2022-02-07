package com.example.geekbang.spring.class14.example1;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: geekbang_springDemo
 * @description: 案例1: @WebFilter过滤器使用@Order无效
 * @author: gao wei
 * @create: 2022-02-07 21:34
 */

@Configuration
public class C14E1FilterConfiguration {
    @Bean
    public FilterRegistrationBean authFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new C14E1AuthFilter());
        registration.addUrlPatterns("/c14/e1/*");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean timeCostFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new C14E1TimeCostFilter());
        registration.addUrlPatterns("/c14/e1/*");
        registration.setOrder(1);
        return registration;
    }
}
