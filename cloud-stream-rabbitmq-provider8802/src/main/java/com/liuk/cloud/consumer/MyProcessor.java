package com.liuk.cloud.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 接收原始消息，经过处理分别发送短信和邮箱的消息驱动微服务应用。
 */
public interface MyProcessor {
    String SOURCE_MESSAGE = "source.message";
    String SMS_MESSAGE = "sms.message";
    String EMAIL_MESSAGE = "email.message";

    @Input(SOURCE_MESSAGE)
    MessageChannel sourceOutput();

    @Output(SMS_MESSAGE)
    SubscribableChannel smsOutput();

    @Output(EMAIL_MESSAGE)
    SubscribableChannel emailOutput();
}
