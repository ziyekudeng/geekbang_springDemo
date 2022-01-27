package com.example.geekbang.spring.class9.example1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：当 @PathVariable 遇到 /
 * @author: gao wei
 * @create: 2022-01-27 15:38
 */

@RestController
@Slf4j
public class C9E1Controller {
    /*
     *原始请求方式
     */
    @RequestMapping(path = "/hi1/{name}", method = RequestMethod.GET)
    public String hello1(@PathVariable("name") String name) {
        return name;

    }

    ;
    /*
     *优化请求方式
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @RequestMapping(path = "/hi1/**", method = RequestMethod.GET)
    public String hi1(HttpServletRequest request) {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        //matchPattern 即为"/hi1/**"
        String matchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return antPathMatcher.extractPathWithinPattern(matchPattern, path);
    }

}
