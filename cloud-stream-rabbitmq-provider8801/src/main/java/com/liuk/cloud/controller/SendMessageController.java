package com.liuk.cloud.controller;

import com.liuk.cloud.service.MessageProvider;
import com.liuk.cloud.service.MyMessageProvider;
import com.liuk.cloud.service.MyMessageProvider02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/stream")
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @Autowired
    private MyMessageProvider myMessageProvider;

    @Autowired
    private MyMessageProvider02 myMessageProvider02;

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
}
