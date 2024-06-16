package com.springbootEvent.event;

import com.springbootEvent.entity.UserEntity;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * 登陆成功事件,所有时间都推荐继承 ApplicationEvent
 */
public class LoginSuccessEvent extends ApplicationEvent {
    /**
     * 传入的参数代表是谁登陆成功了
     * @param source
     */
    public LoginSuccessEvent(UserEntity source) {
        super(source);
    }

    public LoginSuccessEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
