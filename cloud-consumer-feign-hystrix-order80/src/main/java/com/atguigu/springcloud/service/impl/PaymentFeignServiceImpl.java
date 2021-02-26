package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author wangcong
 * @date 2021/2/25 9:15
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "降级方法 paymentInfo_ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "降级方法 paymentInfo_timeout";
    }
}
