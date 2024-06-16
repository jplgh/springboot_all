package com.all.payment.controller;

import com.all.payment.facade.PaystrategyFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PayController {

    private final PaystrategyFacade paystrategyFacade;

    /**
     * 策略模式
     *
     * @param type
     * @return
     */
    @GetMapping("/execute")
    public String pay(String type) {
        return paystrategyFacade.execute(type);
    }

}
