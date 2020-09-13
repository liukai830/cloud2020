package com.liuk.cloud.service.impl;

import com.liuk.cloud.produce.MySource;
import com.liuk.cloud.produce.MySource02;
import com.liuk.cloud.service.MyMessageProvider02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(MySource02.class)
public class MyMessageProviderImpl02 implements MyMessageProvider02 {
    @Autowired
    private MySource02 mySource02;

    @Override
    public String send() {
        String message = "MY02-" + UUID.randomUUID().toString();
        boolean sendFlag = mySource02.myOutput().send(MessageBuilder.withPayload(message).build());
        System.out.println("message:" + message);
        return message;
    }
}
