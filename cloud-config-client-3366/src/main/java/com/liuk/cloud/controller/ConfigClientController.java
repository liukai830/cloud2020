package com.liuk.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description ConfigClientController
 * Created by liuk on 2020/8/23 20:14 .
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return port + ": " + configInfo;
    }
}
