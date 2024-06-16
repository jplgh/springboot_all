package com.all.payment.strategy;

import com.all.payment.common.PayTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class YLPaystrategy implements Paystrategy{

    @Override
    public String type() {
        return PayTypeEnum.YL.getType();
    }

    @Override
    public String execute() {
        return PayTypeEnum.YL.getType();
    }
}