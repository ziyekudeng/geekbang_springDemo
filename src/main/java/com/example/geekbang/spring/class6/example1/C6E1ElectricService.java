package com.example.geekbang.spring.class6.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author gao wei
 * @className: C6E2ElectricService
 * @description 案例 1：错乱混合不同类型的增强
 * @date 2022/1/27/0027 10:35
 */

@Service
public class C6E1ElectricService {
    /*
     *问题复现
     */
    //public void charge() throws Exception {
    //    System.out.println("Electric charging ...");
    //
    //c

    /*
     *修正方式
     */
    @Autowired
    @Lazy
    C6E1ElectricService c6E1ElectricService;

    public void charge() {
        c6E1ElectricService.doCharge();
    }

    public void doCharge() {
        System.out.println("Electric charging ...");
    }
}
