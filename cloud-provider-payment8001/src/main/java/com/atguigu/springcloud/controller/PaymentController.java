package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);

        if (i>0){
            log.info("*************插入成功"+i);
            return new CommonResult(200,"成功"+servicePort,i);

        }else{
            log.info("***********插入失败"+i);
            return new CommonResult(500,"失败111");
        }
    }
    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        int aa = 0;
        Payment payment = paymentService.getPaymentById(id);
        log.info("******结果3333334545553333333333333344444333333333333232 11122333211"+payment);
        if (payment!=null){
            return new CommonResult<Payment>(200,"成功"+servicePort,payment);

        }else{
            return new CommonResult<>(500,"没有对应记录");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        services.forEach(a->log.info("*******element"+a));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(a->log.info("***********uir"+a.getUri()));
        return discoveryClient;
    }
}
