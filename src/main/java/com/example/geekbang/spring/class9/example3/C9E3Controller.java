package com.example.geekbang.spring.class9.example3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @program: geekbang_springDemo
 * @description: 案例 3：未考虑参数是否可选
 * 重点强调： 在 Spring Web 中，默认情况下，请求参数是必选项。
 * @author: gao wei
 * @create: 2022-01-27 15:38
 */

@RestController
@Slf4j
public class C9E3Controller {

    /*
     * 问题出现：http://localhost:8080/hi4?name=xiaoming
     */
    @RequestMapping(path = "/hi4", method = RequestMethod.GET)
    public String hi4(@RequestParam("name") String name, @RequestParam("address") String address) {
        return name + ":" + address;
    }

    /*
     *修正方式一：设置 @RequestParam 的默认值
     * http://localhost:8080/hi4/modify1?name=xiaoming
     */
    @RequestMapping(path = "/hi4/modify1", method = RequestMethod.GET)
    public String hi4M1(@RequestParam("name") String name, @RequestParam(value = "address", defaultValue = "no address") String address) {
        return name + ":" + address;
    }

    /*
     *修正方式二：设置 @RequestParam 的 required 值
     */
    @RequestMapping(path = "/hi4/modify2", method = RequestMethod.GET)
    public String hi4M2(@RequestParam("name") String name, @RequestParam(value = "address", required = false) String address) {
        return name + ":" + address;
    }

    /*
     *修正方式三：标记任何名为 Nullable 且 RetentionPolicy 为 RUNTIME 的注解
     */
    @RequestMapping(path = "/hi4/modify3", method = RequestMethod.GET)
    public String hi4M3(@RequestParam("name") String name, @RequestParam("address") @Nullable String address) {
        return name + ":" + address;
    }

    /*
     *修正方式四：修改参数类型为 Optional
     */
    @RequestMapping(path = "/hi4/modify4", method = RequestMethod.GET)
    public String hi4M4(@RequestParam("name") String name, @RequestParam("address") Optional address) {
        return name + ":" + address;
    }
}
