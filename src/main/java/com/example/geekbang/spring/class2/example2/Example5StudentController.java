package com.example.geekbang.spring.class2.example2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 1：过多赠予，无所适从
 * @author: gao wei
 * @create: 2022-01-25 09:19
 */

@RestController
@Slf4j
public class Example5StudentController {
    /*
     *问题情况：
     */
    //@Autowired
    //@Qualifier("innerClassDataService")
    /*
     *修正方式：使用类名.注入类名（首字母小写）
     */
    @Autowired
    @Qualifier("example5StudentController.InnerClassDataService")
    Example5DataService innerClassDataService;

    @Repository
    public static class InnerClassDataService implements Example5DataService {
        @Override
        public void deleteStudent(int id) {
            //空实现
            log.info("代码执行到这里了：Example5StudentController.InnerClassDataService");
        }
    }
    //省略其他非关键代码

    /**
     * @title getShortName
     * @description 参考 ClassUtils#getShortName 方法：
     * @param className :
     * @return : java.lang.String
     * @author gao wei
     * @date 2022/1/25/0025 14:00
     */
    //public static String getShortName(String className) {
    //
    //    Assert.hasLength(className, "Class name must not be empty");
    //    int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
    //    int nameEndIndex = className.indexOf(CGLIB_CLASS_SEPARATOR);
    //    if (nameEndIndex == -1) {
    //        nameEndIndex = className.length();
    //    }
    //    String shortName = className.substring(lastDotIndex + 1, nameEndIndex);
    //    shortName = shortName.replace(INNER_CLASS_SEPARATOR, PACKAGE_SEPARATOR);
    //    return shortName;
    //}
}
