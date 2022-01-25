package com.example.geekbang.spring.example4;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：过多赠予，无所适从
 * @author: gao wei
 * @create: 2022-01-25 09:19
 */

@RestController
@Slf4j
@Validated
public class StudentController {
    /*
     *修正1:将属性名和 Bean 名字精确匹配
     */
    //@Autowired
    //DataService oracleDataService;
    //
    //
    //@RequestMapping(path = "students/{id}", method = RequestMethod.DELETE)
    //public void deleteStudent(@PathVariable("id") @Range(min = 1,max = 100) int id){
    //    oracleDataService.deleteStudent(id);
    //};

    /*
     *修正2:显式引用 Bean 时首字母忽略大小写
     */
    //@Autowired
    //@Qualifier("cassandraDataService")
    //DataService dataService;
    //
    //
    //@RequestMapping(path = "students/{id}", method = RequestMethod.DELETE)
    //public void deleteStudent(@PathVariable("id") @Range(min = 1,max = 100) int id){
    //    dataService.deleteStudent(id);
    //};

    /*
     *修正3:显式引用 Bean 时首字母忽略大小写
     * 如果一个类名是以两个大写字母开头的，则首字母不变，其它情况下默认首字母变成小写。
     */
    @Autowired
    @Qualifier("SQLiteDataService")
    DataService dataService;

    @RequestMapping(path = "students/{id}", method = RequestMethod.GET)
    public void deleteStudent(@PathVariable("id") @Range(min = 1, max = 100) int id) {
        log.info("注入类名称:"+ decapitalize("SQLiteDataService"));

        dataService.deleteStudent(id);
    }


    public static String decapitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
                Character.isUpperCase(name.charAt(0))){
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }
}
