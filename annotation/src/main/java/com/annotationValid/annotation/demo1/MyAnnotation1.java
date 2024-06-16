package com.annotationValid.annotation.demo1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface MyAnnotation1 {
    String name();
}
