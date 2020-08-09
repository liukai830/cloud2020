package com.liuk.cloud.service;

import com.liuk.cloud.entity.Payment;

public interface IPaymentService {
    int add(Payment payment);

    Payment getPaymentById(Long id);
}
