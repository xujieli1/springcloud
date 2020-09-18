/*
 * Copyright 2017 bianxianmao.com All right reserved. This software is the confidential and proprietary information of
 * bianxianmao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with bianxianmao.com.
 */
package com.jerry.eurekafeign.service;

import com.jerry.eurekafeign.interfaces.HelloInterface;
import org.springframework.stereotype.Component;

/**
 * @Author:jieli.xu
 * @Created: 2019/3/4
 * @Modifier:jieli.xu
 * @Updated:2019/3/4
 * @Description: 错误回调信息
 * @Version:BUILD1001
 */
@Component
public class FallbackErrorService implements HelloInterface {

    @Override
    public String sayHiByFeign(String name) {
        return "feign say error";
    }
}
