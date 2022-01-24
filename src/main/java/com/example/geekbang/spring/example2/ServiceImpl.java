package com.example.geekbang.spring.example2;

import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：定义的 Bean 缺少隐式依赖
 * @author: gao wei
 * @create: 2022-01-24 16:44
 */
@Service
public class ServiceImpl {
    private String serviceName;

    public ServiceImpl(String serviceName) {
        this.serviceName = serviceName;
    }

    /*
     *Spring 内部是用反射来构建 Bean 的话，就不难发现问题所在：存在两个构造器，都可以调用时，到底应该调用哪个呢？
     * 最终 Spring 无从选择，只能尝试去调用默认构造器，而这个默认构造器又不存在，所以测试这个程序它会出错。
     */
    //public ServiceImpl3(String serviceName, String otherStringParameter) {
    //    this.serviceName = serviceName;
    //}
}
