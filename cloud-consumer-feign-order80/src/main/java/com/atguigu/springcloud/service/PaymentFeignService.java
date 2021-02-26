package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangcong
 * @date 2021/2/24 14:06
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    CommonResult<Payment> getByPaymentId(@PathVariable("id") Long id);
}
