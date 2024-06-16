package com.annotationValid.validator;

import com.annotationValid.validator.valid.AddGroups;
import com.annotationValid.validator.valid.UpdateGroups;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/vaild")
public class ValidController {
    /**
     * 这是写了BindingResult 错误没有抛出去
     *
     * @param validVO
     * @param bindingResult 获取校验的结果
     */
    @PostMapping("add")
    public void testValid(@Valid @RequestBody ValidVO validVO, BindingResult bindingResult) {
        //判断是否校验成功
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                //获取校验的错误信息
                String defaultMessage = error.getDefaultMessage();
                System.out.println(defaultMessage);
                //获取错误属性的名字
                String field = error.getField();
                //添加到map中
                errorsMap.put(field, defaultMessage);
            });
        }

        System.out.println("校验通过");
    }


    @PostMapping("addGroup")
    public void testValidGroup(@Validated({AddGroups.class, UpdateGroups.class}) @RequestBody ValidVO validVO, BindingResult bindingResult) {
        //判断是否校验成功
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                //获取校验的错误信息
                String defaultMessage = error.getDefaultMessage();
                System.out.println(defaultMessage);
                //获取错误属性的名字
                String field = error.getField();
                //添加到map中
                errorsMap.put(field, defaultMessage);
            });
        }

        System.out.println("校验通过");
    }


}
