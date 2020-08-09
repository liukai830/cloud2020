package com.liuk.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description PaymentService
 * Created by liuk on 2020/8/8 21:35 .
 * @Version 1.0
 */
@Service
public class PaymentService {
    public String paymentInfoOK(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" paymentInfoOK, id: "+id;
    }

    @HystrixCommand(
        fallbackMethod = "paymentInfoTimeoutHandler",
        commandProperties={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")}
    )
    public String paymentInfoTimeout(Integer id) {
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id+"\t"+" 耗时(秒)"+timeNumber;
    }

    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" paymentInfoTimeoutHandler,id: "+id+"\t"+"8001降级处理";
    }

    /*  服务熔断  */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0) {
            throw new RuntimeException("ID不能小于0");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreakerFallback(Integer id) {
        return "ID不能小于0,请稍后再试,id="+id;
    }
}
