package com.example.geekbang.spring.example8;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：构造器内抛空指针异常
 * 问题原因: 使用 @Autowired 直使用 @Autowired 直接标记在成员属性上而引发的装配行为是发生在构造器执行之后的。
 * 接标记在成员属性上而引发的装配行为是发生在构造器执行之后的。
 * @author: gao wei
 * @create: 2022-01-25 16:16
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LightMgrService {
    /*
     *问题出现情况
     */
    //@Autowired
    //private LightService lightService;
    //
    //public LightMgrService() {
    //    lightService.check();
    //}

    /*
     *修复方式一: 构造器参数的隐式注入
     */

////    private LightService lightService;
//
//    public LightMgrService(LightService lightService) {
////        this.lightService = lightService;
//        lightService.check();
//    }

    /*
     *修复方式二:添加 init 方法，并且使用 PostConstruct 注解进行修饰
     */
    @Autowired
    private LightService lightService;

    @PostConstruct
    public void init() {
        lightService.check();
    }
}
