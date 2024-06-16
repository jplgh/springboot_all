package com.all.payment.service;

import com.all.payment.common.JsonResult;
import com.all.payment.common.RedisConstant;
import com.all.payment.response.SignCountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignServiceImpl implements SignService {
    private final StringRedisTemplate stringRedisTemplate;


    @Override
    public JsonResult sign(String userId) {
        getResult result = getGetResult(userId);
        Boolean bit;
        try {
            bit = stringRedisTemplate.opsForValue().getBit(result.key, result.day - 1);
        } catch (Exception e) {
            return JsonResult.fail("签到失败");
        }
        //签到之后又签到，拒绝
        if (Boolean.TRUE.equals(bit)) {
            return JsonResult.fail("非法请求");
        }
        try {
            stringRedisTemplate.opsForValue().setBit(result.key, result.day - 1, true);
        } catch (Exception e) {
            return JsonResult.fail("签到失败");
        }

        return JsonResult.success();
    }

    private static getResult getGetResult(String userId) {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("yyyy-MM"));
        String key = RedisConstant.SIGN_KEY + userId + time;
        int day = now.getDayOfMonth();
        getResult result = new getResult(key, day);
        return result;
    }

    private record getResult(String key, int day) {
    }

    @Override
    public JsonResult<SignCountResponse> count(String userId) {
        getResult result = getGetResult(userId);
//这个不需要返回，实际返回的结果会由executePipelined()方法以异步方式收集并封装在返回的List<Object>中
        List<Object> objects = stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConnection = (StringRedisConnection) connection;
                //今日是否签到
                Boolean bit = stringRedisTemplate.opsForValue().getBit(result.key, result.day - 1);
                stringRedisConnection.bitfield(result.key, BitFieldSubCommands
                        .create()
                        .get(Boolean.TRUE.equals(bit) ?
                                BitFieldSubCommands.BitFieldType.unsigned(result.day)
                                :
                                BitFieldSubCommands.BitFieldType.unsigned(result.day - 1))
                        .valueAt(0)
                );
                stringRedisConnection.bitCount(result.key, 0, result.day);
                return null;
            }
        });
        System.out.println("打印返回信息" + objects);
        List<Long> sings = (List<Long>) objects.get(0);
        Long num = sings.get(0);
        if (num == 0) {
            return JsonResult.success(SignCountResponse.builder().continuousCount(0).sum(0L).build());
        }
        Integer continuousCount = 0;
        //对这两个二进制数逐位执行按位与运算 仅最低位同时为1，因此按位与运算的结果为1
        while ((num & 1) != 0) {
            continuousCount++;
            //右移一位
            num >>>= 1;
        }

        Long sum = (Long) objects.get(1);
        //清除
        sings.clear();
        //清除
        objects.clear();
        return JsonResult.success(SignCountResponse.builder().continuousCount(continuousCount).sum(sum).build());


    }

    /**
     * 本月签到详情
     *
     * @param userId
     * @return
     */
    @Override
    public JsonResult<List<Integer>> countMonth(String userId) {

        getResult result = getGetResult(userId);
        List<Long> longs = stringRedisTemplate.opsForValue().bitField(result.key, BitFieldSubCommands.create().get(BitFieldSubCommands.BitFieldType.unsigned(result.day)).valueAt(0));
        Long num = longs.get(0);

        List<Integer> integers = new ArrayList<>(result.day);

        for (int i = 0; i < result.day; i++) {
            if ((num & 1) != 0) {
                integers.add(1);
            } else {
                integers.add(0);
            }
            num>>>=1;
        }
         //将顺序翻转
        Collections.reverse(integers);

        //获取本月总天数 形成一个数组
        List<Integer> integers1 = new ArrayList<>();

        int maxLength = LocalDate.now().getMonth().maxLength();

        for (int i = 0; i < maxLength; i++) {
            //获取
            try {
                integers1.add(integers.get(i));
            } catch (Exception e) {
                integers1.add(0);
            }

        }

        System.out.println("本月情况："+integers1);


        return JsonResult.success(integers);
    }

}
