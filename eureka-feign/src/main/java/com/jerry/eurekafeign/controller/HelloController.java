/*
 * Copyright 2017 bianxianmao.com All right reserved. This software is the confidential and proprietary information of
 * bianxianmao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with bianxianmao.com.
 */
package com.jerry.eurekafeign.controller;

import com.jerry.eurekafeign.interfaces.HelloInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jieli.xu
 * @Created: 2019/3/4
 * @Modifier:jieli.xu
 * @Updated:2019/3/4
 * @Description:
 * @Version:BUILD1001
 */
@RestController
@RequestMapping("say")
public class HelloController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    HelloInterface helloInterface;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return helloInterface.sayHiByFeign( name );
    }
}
