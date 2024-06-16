package com.springbootEvent.service;

import com.springbootEvent.entity.UserEntity;
import com.springbootEvent.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 采用实现的方式
 */
@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent> {
    public void addAccountScore(String username) {
        System.out.println("增加积分" + username);

    }

    /**
     *  注意事件是同步的，如果事件处理中抛出异常，则事件不会继续传播，线程中断，返回异常
     * @param event
     */
    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        System.out.println("AccountService   收到事件");

 //              int a = 1/0;

        UserEntity source = (UserEntity) event.getSource();
        addAccountScore(source.getUsername());
    }
}
