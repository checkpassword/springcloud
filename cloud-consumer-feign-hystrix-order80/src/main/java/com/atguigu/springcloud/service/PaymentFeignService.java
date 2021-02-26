package com.atguigu.springcloud.service;


import com.atguigu.springcloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangcong
 * @date 2021/2/24 16:29
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFeignServiceImpl.class)
@Component
public interface PaymentFeignService {
    @GetMapping("/payment/paymentInfo_OK/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping("/payment/paymentInfo_Timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
