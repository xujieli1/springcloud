/*
 * Copyright 2017 bianxianmao.com All right reserved. This software is the confidential and proprietary information of
 * bianxianmao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with bianxianmao.com.
 */
package com.jerry.gateway.controller;

import org.springframework.cloud.gateway.filter.factory.HystrixGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author:jieli.xu
 * @Created: 2020/4/28
 * @Modifier:jieli.xu
 * @Updated:2020/4/28
 * @Description:
 * @Version:BUILD1001
 */
@RestController
@RequestMapping("/")
public class HelloGatway {

    /**
     * 转发/get 请求
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}
