package com.liuk.cloud.controller;

import com.liuk.cloud.consumer.MySink;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(MySink.class)
public class MyReceiveMessageLinstnerController {
    @Value("${server.port}")
    private String port;

    @StreamListener(MySink.MY_INPUT)
    public void input(Message<String> message) {
        System.out.println("接收到消息 -----> " + port + ": " + message.getPayload());
    }
}
