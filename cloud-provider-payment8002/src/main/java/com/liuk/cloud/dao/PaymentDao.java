package com.liuk.cloud.dao;

import com.liuk.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int insert(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
