package com.liuk.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description PaymentFallbackService的fallback处理
 * 实现与业务代码分离
 * Created by liuk on 2020/8/9 15:10 .
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOK(Integer id) {
        return "paymentInfoOK FallBack";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "paymentInfoTimeOut FallBack";
    }
}
