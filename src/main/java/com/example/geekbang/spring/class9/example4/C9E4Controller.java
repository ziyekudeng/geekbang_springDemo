package com.example.geekbang.spring.class9.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: geekbang_springDemo
 * @description: 案例 4：请求参数格式错误
 * 重点强调： 根据源类型和目标类型寻找转化器来执行转化的
 * @author: gao wei
 * @create: 2022-01-27 15:38
 */

@RestController
@Slf4j
public class C9E4Controller {

    @RequestMapping(path = "/hi5", method = RequestMethod.GET)
    public String hi5(@RequestParam("name") String name, @RequestParam("age") int age) {
        return name + " is " + age + " years old";
    }

    /*
     * http://localhost:8080/hi6?date=2021-5-1%2020:26:53
     * 修正方式一： http://localhost:8080/hi6?date=Sat, 12 Aug 1995 13:30:00 GMT
     */
    @RequestMapping(path = "/hi6", method = RequestMethod.GET)
    public String hi6(@RequestParam("date") Date date) {
        return "date is " + date;
    }

    /*
     * http://localhost:8080/hi6?date=2021-5-1%2020:26:53
     * 修正方式二： 标记 @DateTimeFormat
     */
    @RequestMapping(path = "/hi6/modify", method = RequestMethod.GET)
    public String hi6Modify(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date date) {
        return "date is " + date;
    }
}
