package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangcong
 * @date 2021/2/24 16:31
 */
@RestController
@Slf4j
public class OrderHystirxController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/paymentInfo_Timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentFeignService.paymentInfo_Timeout(id);
    }

}
