package com.example.geekbang.spring.class10.example1;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：接受 Header 使用错 Map 类型
 * @author: gao wei
 * @create: 2022-01-27 17:01
 */
public class C9E1Controller {

    @RequestMapping(path = "/c9/e1/hi", method = RequestMethod.GET)
    public String hi(@RequestHeader("myHeaderName") String name) {
        //省略 body 处理
        return name;
    }

    /*
     *问题情况:
     * GET http://localhost:8080/c9/e1/hi1
     * myheader: h1
     * myheader: h2
     */
    @RequestMapping(path = "/c9/e1/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader() Map map) {
        return map.toString();
    }

    /*
     *修正方式一： @RequestHeader() MultiValueMap map
     */
    @RequestMapping(path = "/c9/e1/hi2/modify1", method = RequestMethod.GET)
    public String hi2Modify1(@RequestHeader() MultiValueMap map) {
        return map.toString();
    }

    /*
     *《推荐》修正方式二： @RequestHeader() HttpHeaders map
     */
    @RequestMapping(path = "/c9/e1/hi2/modify2", method = RequestMethod.GET)
    public String hi2Modify2(@RequestHeader() HttpHeaders map) {
        return map.toString();
    }
}
