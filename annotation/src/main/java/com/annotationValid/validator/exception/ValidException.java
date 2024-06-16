package com.annotationValid.validator.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 集中处理所有异常
 */
/*
@ControllerAdvice(basePackages = "com.validator.ValidController")  处理的异常类，可以是多个
@ResponseBody        json响应
*/
@Slf4j
@RestControllerAdvice(basePackages = "com.validator.ValidController")   //将上面两个注解合成一个
public class ValidException {
    /**
     * MethodArgumentNotValidException 这个是校验异常的类
     *
     * @param e
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleException(MethodArgumentNotValidException e) {
        System.out.println("异常处理");
        log.error("数据校验出现问题{}，异常类型{}", e.getMessage(), e.getClass());
        Map<String, String> errorsMap = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(fieldError -> errorsMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
        System.out.println(errorsMap);
    }


}
