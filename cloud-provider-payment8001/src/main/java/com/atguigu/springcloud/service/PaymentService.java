package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    /**
     * 增加
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 查询
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
