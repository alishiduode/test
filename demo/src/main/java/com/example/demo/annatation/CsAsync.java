package com.example.demo.annatation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cs
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CsAsync {

    String name() default "自定义异步注解";

    /**
     * 多久后开始异步任务，默认一秒钟
     * @return
     */
    long time() default 1000;
}
