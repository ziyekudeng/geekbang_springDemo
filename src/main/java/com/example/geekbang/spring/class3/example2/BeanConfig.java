package com.example.geekbang.spring.class3.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：错乱的注入集合
 * @author: gao wei
 * @create: 2022-01-25 15:35
 */
@Configuration
public class BeanConfig {

    /*
     *方式一:收集式装配
     */
    //@Bean
    //public Student student1() {
    //    return createStudent(1, "xie");
    //}
    //
    //@Bean
    //public Student student2() {
    //    return createStudent(2, "fang");
    //}

    //@Bean
    //public List<Student> students() {
    //    Student student3 = createStudent(3, "liu");
    //    Student student4 = createStudent(4, "fu");
    //    return Arrays.asList(student3, student4);
    //}

    /*
     *方式二:直接装配
     * 方式二不能与方式一共存
     */

    @Bean
    public List<Student> students() {
        Student student1 = createStudent(1, "xie");
        Student student2 = createStudent(2, "fang");
        Student student3 = createStudent(3, "liu");
        Student student4 = createStudent(4, "fu");
        return Arrays.asList(student1, student2, student3, student4);
    }

    private Student createStudent(int id, String name) {
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        return student;
    }
}
