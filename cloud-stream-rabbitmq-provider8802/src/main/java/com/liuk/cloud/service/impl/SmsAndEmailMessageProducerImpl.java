package com.liuk.cloud.service.impl;

import com.liuk.cloud.consumer.MyProcessor;
import com.liuk.cloud.service.SmsAndEmailMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(MyProcessor.class)
public class SmsAndEmailMessageProducerImpl implements SmsAndEmailMessageProducer {
    @Autowired
    private MyProcessor myProcessor;

    @Override
    public void sendSms(String smsMessage) {
        myProcessor.smsOutput().send(MessageBuilder.withPayload(smsMessage).build());
        System.out.println("电话号码消息发送成功，消息为：" + smsMessage);
    }

    @Override
    public void sendEmail(String emailMessage) {
        myProcessor.emailOutput().send(MessageBuilder.withPayload(emailMessage).build());
        System.out.println("邮箱地址消息发送成功，消息为：" + emailMessage);
    }
}
