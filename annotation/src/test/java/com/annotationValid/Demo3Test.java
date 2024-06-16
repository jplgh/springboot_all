package com.annotationValid;

import com.annotationValid.annotation.demo3.Demo3;
import com.annotationValid.annotation.demo3.IsNotNull;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Parameter;


/**
 */
public class Demo3Test {

    @Test
    public void hello1() throws Exception {
        Demo3 demo3 = new Demo3();
        for (Parameter parameter : demo3.getClass().getMethod("hello1", String.class).getParameters()) {
            IsNotNull annotation = parameter.getAnnotation(IsNotNull.class);
            if(annotation != null){
                System.out.println(annotation.value());//true
            }
        }
    }

    @Test
    public void hello2() throws Exception {
        Demo3 demo3 = new Demo3();
        for (Parameter parameter : demo3.getClass().getMethod("hello2", String.class).getParameters()) {
            IsNotNull annotation = parameter.getAnnotation(IsNotNull.class);
            if(annotation != null){
                System.out.println(annotation.value());//false
            }
        }
    }
}

