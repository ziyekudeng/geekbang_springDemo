package com.example.geekbang.spring.class19.example2;

import com.example.geekbang.spring.class19.C19JdbcConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-02-09 11:46
 */

@Configuration
@ComponentScan
@Import({C19JdbcConfig.class})
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.example.geekbang.spring.class19.*")
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class AppConfig {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*
         *Class 19 example2
         */
        C19E2StudentService studentService = (C19E2StudentService) context.getBean("c19E2StudentService");
        studentService.saveStudent("小明");
    }
}
