package com.springbootEvent.service;

import com.springbootEvent.entity.UserEntity;
import com.springbootEvent.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CouponService {
    /**
     *  Async 是异步执行
     * 采用注解的形式
     * @param event
     */
    @EventListener
    @Async
    public void onEvent(LoginSuccessEvent event) {

        try {
            //随眠10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("有线程睡眠");

        System.out.println("注解形式，增加优惠卷");
        UserEntity source = (UserEntity) event.getSource();
        addCouponService(source.getUsername());
    }



    public void addCouponService(String username) {
        System.out.println("增加优惠卷"+username);

    }
}
