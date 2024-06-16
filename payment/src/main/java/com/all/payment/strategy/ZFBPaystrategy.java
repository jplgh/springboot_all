package com.all.payment.strategy;

import com.all.payment.common.PayTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class ZFBPaystrategy implements Paystrategy{

    @Override
    public String type() {
        return PayTypeEnum.ZFB.getType();
    }

    @Override
    public String execute() {
        return PayTypeEnum.ZFB.getType();
    }
}