/*
 * Copyright 2017 bianxianmao.com All right reserved. This software is the confidential and proprietary information of
 * bianxianmao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with bianxianmao.com.
 */
package com.jerry.eurekaconfigserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jieli.xu
 * @Created: 2020/4/23
 * @Modifier:jieli.xu
 * @Updated:2020/4/23
 * @Description:
 * @Version:BUILD1001
 */
@RestController
@RequestMapping("/")
@RefreshScope
public class HelloConfigController {

    @Value("${test.sex}")
    private String message;

    @RequestMapping("/config")
    public String sayConfig(){
        return "读取到的配置文件内容是："+message;
    }
}
