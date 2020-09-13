package com.liuk.cloud.controller;

import com.liuk.cloud.service.MessageProvider;
import com.liuk.cloud.service.MyMessageProvider;
import com.liuk.cloud.service.MyMessageProvider02;
import com.liuk.cloud.service.SourceMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/stream")
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @Autowired
    private MyMessageProvider myMessageProvider;

    @Autowired
    private MyMessageProvider02 myMessageProvider02;

    @Autowired
    private SourceMessageProducer sourceMessageProducer;

    @GetMapping("/send")
    public String send() {
        return  messageProvider.send();
    }

    @GetMapping("/send2")
    public String send2() {
        return  myMessageProvider.send();
    }

    @GetMapping("/send3")
    public String send3() {
        return  myMessageProvider02.send();
    }


    @GetMapping("/send4")
    public String send4() {
        sourceMessageProducer.send("10086|10086@email.com");
        return "发送成功！" + UUID.randomUUID().toString();
    }

}
