package com.annotationValid.annotation.demo1;

import jakarta.validation.constraints.Email;

/**
 *
 * 获取类与方法上的注解值
 */
@MyAnnotation1(name = "abc")
public class Demo1 {

    @MyAnnotation1(name = "xyz")
    @Email
    private Integer age;

    @MyAnnotation2(model = TranscationModel.Read)
    public void list() {
        System.out.println("list");
    }

    @MyAnnotation3(models = {TranscationModel.Read, TranscationModel.Write})
    public void edit() {
        System.out.println("edit");
    }
}

