package com.liuk.cloud.service.impl;

import com.liuk.cloud.produce.MySource;
import com.liuk.cloud.service.MyMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@EnableBinding(MySource.class)
public class MyMessageProviderImpl implements MyMessageProvider {

    @Autowired
    private MySource mySource;

    @Override
    public String send() {
        String message = "MY-" + UUID.randomUUID().toString();
        boolean sendFlag = mySource.myOutput().send(MessageBuilder.withPayload(message).build());
        System.out.println("message:" + message);
        return message;
    }
}
