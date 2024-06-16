package com.all.payment;

import com.all.payment.common.JsonResult;
import com.all.payment.response.SignCountResponse;
import com.all.payment.service.SignService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
class MyRedisApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SignService signService;


    @Test
    void contextLoads() {

        stringRedisTemplate.opsForValue().set("name", "zhangsan");
    }


    @Test
    public void test() {
        signService.sign("123");




    }

    @Test
    public void test1() {

        JsonResult<SignCountResponse> count = signService.count("123");
        System.out.println("最终结果:"+count);

    }


    @Test
    public void test2() {
        JsonResult<List<Integer>> listJsonResult = signService.countMonth("123");

        System.out.println("最终结果:"+listJsonResult);

    }




    @Test
    public void testddd1() {

        Long increment = stringRedisTemplate.opsForValue().increment("123",1);
        System.out.println("最终结果:"+increment);

    }



}
