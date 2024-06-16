package com.all.payment.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignCountResponse {
    /**
     * 连续签到
     */
    private Integer continuousCount;
    /**
     * 统计签到
     */
    private Long sum;

}
