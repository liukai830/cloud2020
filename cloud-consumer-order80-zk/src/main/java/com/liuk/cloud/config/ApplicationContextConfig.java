package com.liuk.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   // 使用该注解赋予RestTemplate负载均衡的能力(Ribbon提供的客户端)
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
