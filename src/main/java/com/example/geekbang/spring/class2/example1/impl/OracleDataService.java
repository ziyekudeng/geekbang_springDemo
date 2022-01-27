package com.example.geekbang.spring.class2.example1.impl;

import com.example.geekbang.spring.class2.example1.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-01-25 09:21
 */
/*
 *修正方式:显式指明Bean名称
 */
@Repository("OracleDataService")
@Slf4j
public class OracleDataService implements DataService {
    @Override
    public void deleteStudent(int id) {
        log.info("delete student info maintained by oracle");
    }
}
