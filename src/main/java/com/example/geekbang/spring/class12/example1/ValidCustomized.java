package com.example.geekbang.spring.class12.example1;

/**
 * @program: geekbang_springDemo
 * @description: 自定义一个以 Valid 关键字开头的注解
 * @author: gao wei
 * @create: 2022-02-07 11:18
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCustomized {
  /**
   * @className: ValidCustomized
   * @description 一定要注意自定义的注解要显式标记 @Retention(RetentionPolicy.RUNTIME)，否则校验仍不生效。
   * 究其原因，不显式标记 RetentionPolicy 时，默认使用的是 RetentionPolicy.CLASS，
   * 而这种类型的注解信息虽然会被保留在字节码文件（.class）中，但在加载进 JVM 时就会丢失了。
   * @author gao wei
   * @date 2022/2/7/0007 11:19
   */
}
