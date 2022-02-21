package com.zf.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService  implements  PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------paymentInfo_OK fall back";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------paymentInfo_TimeOut";
    }
}
