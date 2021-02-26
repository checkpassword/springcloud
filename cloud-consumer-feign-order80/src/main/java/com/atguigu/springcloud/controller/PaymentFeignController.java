package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangcong
 * @date 2021/2/24 14:43
 */
@RestController
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getByPaymentId(@PathVariable("id") Long id){
        return paymentFeignService.getByPaymentId(id);
    }
}
