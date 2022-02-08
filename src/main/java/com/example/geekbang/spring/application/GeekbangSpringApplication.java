package com.example.geekbang.spring.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan("com.example.geekbang.spring.class*.*")
@EnableAspectJAutoProxy(exposeProxy = true)
@ServletComponentScan("com.example.geekbang.spring.class*.*")
@Slf4j
public class GeekbangSpringApplication {
    /**
     * Class 18
     * @param redisTemplate
     * @param stringRedisTemplate
     */
    //void SpringdataApplication(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate) {
    //    String key = "mykey";
    //    stringRedisTemplate.opsForValue().set(key, "myvalue");
    //    Object valueGotFromStringRedisTemplate = stringRedisTemplate.opsForValue().get(key);
    //    System.out.println(valueGotFromStringRedisTemplate);
    //    Object valueGotFromRedisTemplate = redisTemplate.opsForValue().get(key);
    //    System.out.println(valueGotFromRedisTemplate);
    //}

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GeekbangSpringApplication.class, args);
        log.info("启动成功");
        /*
         *服务完整运行后停止
         */
        //context.close();
        //log.info("服务完整运行后停止");
    }

}
