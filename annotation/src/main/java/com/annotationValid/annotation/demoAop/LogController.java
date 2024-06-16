package com.annotationValid.annotation.demoAop;

import org.springframework.stereotype.Component;

/**
 */
@Component
public class LogController {

    @MyLog(desc = "这是结合spring aop知识，讲解自定义注解应用的一个案例")
    public void testLogAspect(){
        System.out.println("这里随便来点啥");
    }



    @MyLog(desc = "这是结合spring aop知识，讲解自定义注解应用的一个案例")
    public void testLogAspect(String name,int age) {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这里随便来点啥");
    }





}
