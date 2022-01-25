package com.example.geekbang.spring.example4.impl;

import com.example.geekbang.spring.example4.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-01-25 09:32
 */
/*
*修正方式:显式指明Bean名称
 */
@Repository("CassandraDataService")
@Slf4j
public class CassandraDataService implements DataService {
    @Override
    public void deleteStudent(int id) {
        log.info("delete student info maintained by cassandra");
    }
}
