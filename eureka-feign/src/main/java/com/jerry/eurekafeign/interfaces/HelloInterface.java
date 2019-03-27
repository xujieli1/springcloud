package com.jerry.eurekafeign.interfaces;

import com.jerry.eurekafeign.service.FallbackErrorService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:jieli.xu
 * @Created: 2019/3/4
 * @Modifier:jieli.xu
 * @Updated:2019/3/4
 * @Description:
 * @Version:BUILD1001
 */
@FeignClient(name = "service-hi" ,fallback = FallbackErrorService.class) /** 指定调用哪个接口 **/
public interface HelloInterface {

    @RequestMapping(value = "/say/hi",method = RequestMethod.GET)
    String sayHiByFeign(@RequestParam(value = "name") String name);
}
