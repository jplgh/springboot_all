package com.all.payment.strategy;

import com.all.payment.common.PayTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class WXPaystrategy implements Paystrategy{

    @Override
    public String type() {
        return PayTypeEnum.WX.getType();
    }

    @Override
    public String execute() {
        return PayTypeEnum.WX.getDesc();
    }
}
