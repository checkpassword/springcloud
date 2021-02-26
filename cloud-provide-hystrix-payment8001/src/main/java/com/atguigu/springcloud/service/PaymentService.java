package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author wangcong
 * @date 2021/2/24 15:28
 */
@Service
@Slf4j
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"    paymentInfo_OK    "+ id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    } )
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = (int)(Math.random()*10);
        log.info("随机到了"+timeNumber+"秒的时间");
        try{
            TimeUnit.SECONDS.sleep(timeNumber);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：  "+Thread.currentThread().getName()+"    paymentInfo_Timeout    "+ id +"耗时"+timeNumber+"秒钟";
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：  "+Thread.currentThread().getName()+"    paymentInfo_Timeout    "+ id +"请等待";

    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")

    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id< 0 ){
            throw new RuntimeException("**********id不能为负数"+id);
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数,请稍后再试 id="+id;
    }
}
