package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface PaymentMapper {
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
