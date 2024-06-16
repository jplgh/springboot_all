package com.springbootEvent.controller;

import com.springbootEvent.entity.UserEntity;
import com.springbootEvent.event.EventPublisher;
import com.springbootEvent.event.LoginSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springbootEvent.service.AccountService;
import com.springbootEvent.service.CouponService;
import com.springbootEvent.service.SysService;

@RestController
public class LoginController {

    @Autowired
    private AccountService accountService;


    @Autowired
    private CouponService couponService;


    @Autowired
    private SysService sysService;


    //发送事件
    @Autowired
    private EventPublisher eventPublisher;

    /**
     * 没有使用事件驱动的方式
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        System.out.println("业务处理登录完成......" + password);


        // TODO 发送事件  事件是同步的，这意味着发布者线程将阻塞，直到所有监听都完成对事件的处理为止
        //1：准备事件
        LoginSuccessEvent event = new LoginSuccessEvent(new UserEntity("DE", "DA"));

        //2：发送事件
        eventPublisher.sendEvent(event);


        //1：增加积分
        accountService.addAccountScore(username);
        //2：增加优惠卷
        couponService.addCouponService(username);
        //3：系统记录信息
        sysService.addSysService(username);

        return "登陆成功返回信息" + username;
    }

}
