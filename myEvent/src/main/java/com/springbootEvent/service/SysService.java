package com.springbootEvent.service;

import com.springbootEvent.entity.UserEntity;
import com.springbootEvent.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class SysService {




    /**
     * 采用注解的形式
     * Order 数字越小 优先级越高
     * @param event
     */
    @EventListener
    @Order(1)
    public void onEvent1(LoginSuccessEvent event) {
        System.out.println("注解形式，系统记录信息1");
        UserEntity source = (UserEntity) event.getSource();
        addSysService(source.getUsername());
    }



    /**
     * 采用注解的形式
     * @param event
     */
    @Order(2)
    @EventListener
    public void onEvent2(LoginSuccessEvent event) {
        System.out.println("注解形式，系统记录信息2");
        UserEntity source = (UserEntity) event.getSource();
        addSysService(source.getUsername());
    }

    /**
     * 采用注解的形式
     * @param event
     */
    @Order(3)
    @EventListener
    public void onEvent3(LoginSuccessEvent event) {
        System.out.println("注解形式，系统记录信息3");
        UserEntity source = (UserEntity) event.getSource();
        addSysService(source.getUsername());
    }




    public void addSysService(String username) {
        System.out.println("系统记录信息"+username);

    }
}
