package com.example.geekbang.spring.class9.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：错误使用 @RequestParam、@PathVarible 等注解
 * @author: gao wei
 * @create: 2022-01-27 15:38
 */

@RestController
@Slf4j
public class C9E2Controller {

    /*
     * http://localhost:8080/hi2/test1?name=gao
     */
    @RequestMapping(path = "/hi2/test1", method = RequestMethod.GET)
    public String hi1(@RequestParam("name") String name) {
        return name;
    }

    ;

    @RequestMapping(path = "/hi2/test2", method = RequestMethod.GET)
    public String hi2(@RequestParam String name) {
        return name;
    }
    /*
     *思考题： http://localhost:8080/hi2/test?name=xiaoming&name=hanmeimei
     */

    @RequestMapping(path = "/hi2/test", method = RequestMethod.GET)
    public String hi3(@RequestParam("name") String name) {
        return name;
    }

    ;
}
