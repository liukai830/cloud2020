package com.liuk.cloud.controller;

import com.liuk.cloud.service.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/stream")
public class SendMessageController {

    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        return  messageProvider.send();
    }

}
