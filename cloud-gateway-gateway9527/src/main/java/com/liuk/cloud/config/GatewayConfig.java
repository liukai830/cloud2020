package com.liuk.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 硬编码路由转发配置
 * Created by liuk on 2020/8/12 20:31 .
 * @Version 1.0
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return  routeLocatorBuilder.routes()
                .route("my_route_a", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("my_route_a", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
    }

}
