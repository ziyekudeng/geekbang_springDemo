package com.example.geekbang.spring.class1.example3;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 案例三
 */
@Log
@RestController
public class Example3Controller {

    @Autowired
    private ServiceImpl3 serviceImpl;
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(path = "hi3", method = RequestMethod.GET)
    public String hi() {
        /*
         *情况：多例不生效，始终返回一个单例
         */
        //    return "helloworld, service is : " + serviceImpl;
        /*
         *修正后
         */
        return "helloworld, service is : " + getServiceImpl();
    }

    ;

    /*
     *修正：方式一
     */
    //public ServiceImpl3 getServiceImpl() {
    //    return applicationContext.getBean(ServiceImpl3.class);
    //}

    /*
    *修正：方式二
     */
    @Lookup
    public ServiceImpl3 getServiceImpl() {
        //下面的日志会输出么？
        log.info("executing this method");
        /*
        *方法调用最终并没有走入案例代码实现的 return null 语句，而是通过 BeanFactory 来获取 Bean。
         */
        return null;
    }
}
