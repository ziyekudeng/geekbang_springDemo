package com.example.geekbang.spring.class6.example2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：错乱混合同类型增强
 * @author: gao wei
 * @create: 2022-01-27 10:36
 */

//省略 imports
@Aspect
@Service
@Slf4j
public class C6E2AspectService {
    /*
     * 切面注解排序: 依次为 Around.class, Before.class, After.class, AfterReturning.class, AfterThrowing.class
     * 问题: 当同一个切面包含多个同一种类型的多个增强，且修饰的都是同一个方法时，这多个增强的执行顺序是怎样的？
     * 答案: 首先按照按照增强类型排序,然后根据方法名排序
     * 如果两个方法名长度相同，则依次比较每一个字母的 ASCII 码，ASCII 码越小，排序越靠前；
     * 若长度不同，且短的方法名字符串是长的子集时，短的排序靠前
     */

    @Before("execution(* com.example.geekbang.spring.class6.example2.C6E2ElectricService.charge())")
    public void logBeforeMethod(JoinPoint pjp) throws Throwable {
        System.out.println("step into ->" + pjp.getSignature());
    }

    /*
     * 问题复现
     */
    //@Before("execution(* com.example.geekbang.spring.class6.example2.C6E2ElectricService.charge()) ")
    //public void validateAuthority(JoinPoint pjp) throws Throwable {
    //    throw new RuntimeException("authority check failed");
    //}

    /*
     * 问题修正:可以将原来的 validateAuthority() 改为 checkAuthority()，
     * 这种情况下，对增强（Advisor）的排序，其实最后就是在比较字符 l 和 字符 c。
     */
    @Before("execution(* com.example.geekbang.spring.class6.example2.C6E2ElectricService.charge()) ")
    public void checkAuthority(JoinPoint pjp) throws Throwable {
        throw new RuntimeException("authority check failed");
    }
}
