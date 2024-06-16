package com.annotationValid.annotation.demoAop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 定义切面类
 */
@Component
@Aspect
public class MyLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(MyLogAspect.class);

    /**
     * 只要用到了com.annotation.demoAop.MyLog这个注解的，就是目标类
     */
    @Pointcut("@annotation(com.annotationValid.annotation.demoAop.MyLog)")
    private void MyValid() {
    }

    @Before("MyValid()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logger.debug("[" + signature.getName() + " : start.....]");
        System.out.println("[" + signature.getName() + " : start.....]");

        MyLog myLog = signature.getMethod().getAnnotation(MyLog.class);
        logger.debug("【目标对象方法被调用时候产生的日志，记录到日志表中】："+myLog.desc());
        System.out.println("【目标对象方法被调用时候产生的日志，记录到日志表中】：" + myLog.desc());
    }

    @Around("MyValid()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = pjp.getArgs();
        System.out.println(Arrays.toString(args));
        Object ob = pjp.proceed();// ob 为方法的返回值
        System.out.println("耗时 : " + (System.currentTimeMillis() - startTime) + "ms");
        return ob;
    }


}

