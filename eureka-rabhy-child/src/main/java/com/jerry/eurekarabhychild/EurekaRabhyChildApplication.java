package com.jerry.eurekarabhychild;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 1:zuul网关-可以把请求转发到指定的service-id上面，具体配置看application.properties,请求示例
 * ····http://localhost:8769/api-a/say/hi?name=forezp
 * ····http://localhost:8769/api-b/say/hi?name=forezp
 * 2:可以用来做服务过滤 具体配置看MyFilter.java
 */
@SpringBootApplication
@EnableZuulProxy/** 启用zuul服务网关 **/
@EnableEurekaClient
@EnableDiscoveryClient
public class EurekaRabhyChildApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRabhyChildApplication.class, args);
	}

}
