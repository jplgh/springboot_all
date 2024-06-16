package com.all.payment.controller;


import com.all.payment.common.JsonResult;
import com.all.payment.response.SignCountResponse;
import com.all.payment.service.SignService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignController {

    @Resource
    private SignService signService;
    /**
     * 执行签到
     * @param type
     * @return
     */
    @PostMapping("/execute")
    public JsonResult sign(String type) {
        return signService.sign(type);
    }



    /**
     * 统计签到
     * @param type
     * @return
     */
    @PostMapping("/count")
    public JsonResult<SignCountResponse> count(String type) {
        return signService.count(type);
    }


    /**
     * 本月签到详情
     * @param type
     * @return
     */
    @PostMapping("/month")
    public JsonResult<List<Integer>> countMonth(String type) {
        return signService.countMonth(type);
    }






    public static void main(String[] args) {

        Integer num = 11;
        Integer count = 0;
        //对这两个二进制数逐位执行按位与运算 仅最低位同时为1，因此按位与运算的结果为1
        while ((num & 1) != 0) {
            count++;
            //右移一位
            num >>>= 1;
        }
        System.out.println(count);

    }
}
