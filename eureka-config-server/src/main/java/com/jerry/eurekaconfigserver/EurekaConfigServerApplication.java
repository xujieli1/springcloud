package com.jerry.eurekaconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

//我就是个读取所有配置文件的，不管哪个都给你加载出来
//我是否访问成功？ 地址： https://host:端口/你的配置文件名
//格式如下
/*		/{application}/{profile}[/{label}]
		/{application}-{profile}.yml
		/{label}/{application}-{profile}.yml
		/{application}-{profile}.properties
		/{label}/{application}-{profile}.properties

*/
@SpringBootApplication
//启用配置服务
@EnableConfigServer
@EnableDiscoveryClient
public class EurekaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServerApplication.class, args);
	}

}
