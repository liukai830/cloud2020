package com.liuk.cloud.controller;

import com.liuk.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description OrderHystrixController
 * Created by liuk on 2020/8/9 12:37 .
 * @Version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoOK(id);
        log.info("*******result:"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(
//            fallbackMethod = "paymentInfoTimeoutHandler",
//            commandProperties={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")}
//    )
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        log.info("*******result:"+result);
        return result;
    }
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池: "+Thread.currentThread().getName()+" paymentInfoTimeoutHandler,id: "+id+"\t"+"80降级处理";
    }

    public String paymentGlobalFallback() {
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
