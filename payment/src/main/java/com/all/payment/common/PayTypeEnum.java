package com.all.payment.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PayTypeEnum {

    ZFB("0", "支付宝"),
    WX("1", "微信支付"),
    YL("1", "银联支付");


    private final String type;
    private final String desc;

}

