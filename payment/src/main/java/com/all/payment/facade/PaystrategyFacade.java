package com.all.payment.facade;

import com.all.payment.common.PayTypeEnum;
import com.all.payment.strategy.Paystrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaystrategyFacade {
    private final List<Paystrategy> paystrategies;


    public String execute(String type) {
        Paystrategy notFoundPayStrategy = paystrategies
                .stream()
                .filter(paystrategy -> paystrategy.type().equals(type))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("not found pay strategy"));
        System.out.println("打印"+notFoundPayStrategy.getClass());
        return notFoundPayStrategy.execute();

    }
}
