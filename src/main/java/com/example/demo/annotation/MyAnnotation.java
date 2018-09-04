package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by mahongbin on 2018/8/23.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

}
