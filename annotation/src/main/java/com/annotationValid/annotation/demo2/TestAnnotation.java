package com.annotationValid.annotation.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 */
//@Retention(RetentionPolicy.SOURCE)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TestAnnotation {
    String value() default "默认value值";

    String what() default "这里是默认的what属性对应的值";
}

