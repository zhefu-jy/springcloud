package com.zf.springcloud.service.impl;

import com.zf.springcloud.dao.PaymentDao;
import com.zf.springcloud.entities.Payment;
import com.zf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl  implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment  getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
