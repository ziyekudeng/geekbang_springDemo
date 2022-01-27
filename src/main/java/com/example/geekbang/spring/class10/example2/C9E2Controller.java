package com.example.geekbang.spring.class10.example2;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：接受 Header 使用错 Map 类型
 * @author: gao wei
 * @create: 2022-01-27 17:01
 */
public class C9E2Controller {
    /*
     *GET http://localhost:8080/hi2
     * myheader: myheadervalue
     */

    @RequestMapping(path = "/c9/e2/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader) {
        return myHeader;
    }

    /*
     *问题情况
     */
    @RequestMapping(path = "/c9/e2/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader, @RequestHeader MultiValueMap map) {
        return myHeader + " compare with : " + map.get("MyHeader");
    }

    /*
     *修正方式一
     */
    @RequestMapping(path = "/c9/e2/hi2/modify", method = RequestMethod.GET)
    public String hi2Modify(@RequestHeader("MyHeader") String myHeader, @RequestHeader MultiValueMap map) {
        return myHeader + " compare with : " + map.get("myHeader");
    }
    /*
     *修正方式二
     */

    @RequestMapping(path = "/c9/e2/hi2", method = RequestMethod.GET)
    public String hi2(@RequestHeader("MyHeader") String myHeader, @RequestHeader HttpHeaders map){
        return myHeader + " compare with : " + map.get("MyHeader");
    };
}
