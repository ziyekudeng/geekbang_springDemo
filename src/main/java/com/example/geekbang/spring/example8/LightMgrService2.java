package com.example.geekbang.spring.example8;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：构造器内抛空指针异常
 * 问题原因: 使用 @Autowired 直使用 @Autowired 直接标记在成员属性上而引发的装配行为是发生在构造器执行之后的。
 * 接标记在成员属性上而引发的装配行为是发生在构造器执行之后的。
 * @author: gao wei
 * @create: 2022-01-25 16:16
 */

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LightMgrService2 implements InitializingBean {
    /*
     *修复方式三:实现 InitializingBean 接口，在其 afterPropertiesSet() 方法中执行初始化代码：
     */
    @Autowired
    private LightService lightService;

    @Override
    public void afterPropertiesSet() throws Exception {
        lightService.start();
    }
}
