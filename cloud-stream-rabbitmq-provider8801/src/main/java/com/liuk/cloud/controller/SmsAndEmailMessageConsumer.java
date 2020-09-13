package com.liuk.cloud.controller;


import com.liuk.cloud.produce.MyProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(MyProcessor.class)
public class SmsAndEmailMessageConsumer {
    /**
     * 接收消息 电话号码
     *
     * @param phoneNum
     */
    @StreamListener(MyProcessor.SMS_MESSAGE)
    public void receiveSms(String phoneNum) {
        System.out.println("电话号码为：" +  phoneNum + "，调用短信发送服务，发送短信...");
    }

    /**
     * 接收消息 邮箱地址
     *
     * @param emailAddress
     */
    @StreamListener(MyProcessor.EMAIL_MESSAGE)
    public void receiveEmail(String emailAddress) {
        System.out.println("邮箱地址为：" + emailAddress + "，调用邮件发送服务，发送邮件...");
    }
}
