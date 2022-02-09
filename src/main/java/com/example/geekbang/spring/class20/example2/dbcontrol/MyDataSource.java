package com.example.geekbang.spring.class20.example2.dbcontrol;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：多数据源间切换之谜
 * @author: gao wei
 * @create: 2022-02-09 14:58
 */

public class MyDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> key = new ThreadLocal<String>();

    @Override
    protected Object determineCurrentLookupKey() {
        return key.get();
    }

    public static void setDataSource(String dataSource) {
        key.set(dataSource);
    }

    public static String getDatasource() {
        return key.get();
    }

    public static void clearDataSource() {
        key.remove();
    }
}
