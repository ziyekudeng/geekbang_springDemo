package com.example.geekbang.spring.class21.example1;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-02-09 17:54
 */
public class UrlTest {
    public static void main(String[] args) {

        RestTemplate template = new RestTemplate();

        //错误：
        //Map<String, Object> paramMap = new HashMap<String, Object>();
        //paramMap.put("para1", "001");
        //paramMap.put("para2", "002");

        //修正代码：
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("para1", "001");
        paramMap.add("para2", "002");

        String url = "http://localhost:8080/hi";
        String result = template.postForObject(url, paramMap, String.class);
        System.out.println(result);
    }
}
