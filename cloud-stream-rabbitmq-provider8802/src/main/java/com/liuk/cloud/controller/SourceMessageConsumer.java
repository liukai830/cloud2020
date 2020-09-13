package com.liuk.cloud.controller;

import com.liuk.cloud.consumer.MyProcessor;
import com.liuk.cloud.service.SmsAndEmailMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyProcessor.class)
public class SourceMessageConsumer {
    @Autowired
    private SmsAndEmailMessageProducer smsAndEmailMessageProducer;

    /**
     * 接收原始消息，处理后并发送
     *
     * @param sourceMessage
     */
    @StreamListener(MyProcessor.SOURCE_MESSAGE)
    public void receive(String sourceMessage) {
        System.out.println("原始消息接收成功，原始消息为：" + sourceMessage);
        // 发送消息 电话号码
        smsAndEmailMessageProducer.sendSms(sourceMessage.split("\\|")[0]);
        // 发送消息 邮箱地址
        smsAndEmailMessageProducer.sendEmail(sourceMessage.split("\\|")[1]);
    }
}
