package com.zf.springcloud.controller;

import com.zf.springcloud.entities.CommonResult;
import com.zf.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
   // public static final String PAYMENT_URL="http://localhost:8001";
   // 通过在eureka上注册过的微服务名称调用
   public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

      @Resource
       private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
       if(entity.getStatusCode().is2xxSuccessful()){
           return entity.getBody();
       }else{
           return new CommonResult<>(444,"操作失败");
       }
    }

}
