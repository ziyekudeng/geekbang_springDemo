package com.example.geekbang.spring.class21.example3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @program: geekbang_springDemo
 * @description:
 * @author: gao wei
 * @create: 2022-02-09 17:54
 */
public class UrlTest {
    public static void main(String[] args) {


        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/hi");
        builder.queryParam("para1", "开发测试 001");
        //错误
        //String url = builder.toUriString();
        URI url = builder.encode().build().toUri();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity.getBody());
    }
}
