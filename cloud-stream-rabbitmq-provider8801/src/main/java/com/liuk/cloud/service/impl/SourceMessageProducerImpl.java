package com.liuk.cloud.service.impl;

import com.liuk.cloud.produce.MyProcessor;
import com.liuk.cloud.service.SourceMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;


@EnableBinding(MyProcessor.class)
public class SourceMessageProducerImpl implements SourceMessageProducer {
    @Autowired
    private MyProcessor myProcessor;

    @Override
    public void send(String sourceMessage) {
        myProcessor.sourceOutput().send(MessageBuilder.withPayload(sourceMessage).build());
        System.out.println("原始消息发送成功，原始消息为：" + sourceMessage);
    }
}
