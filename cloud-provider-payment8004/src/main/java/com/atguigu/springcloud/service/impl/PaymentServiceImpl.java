package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;
    /**
     * 增加
     * @param payment
     * @return
     */
    @Override
    public int create(Payment payment){
        return paymentMapper.create(payment);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById( Long id){
        return paymentMapper.getPaymentById(id);
    }
}
