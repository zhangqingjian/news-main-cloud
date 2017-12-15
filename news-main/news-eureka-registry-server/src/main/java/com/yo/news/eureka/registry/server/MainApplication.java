package com.yo.news.eureka.registry.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 标识其为服务注册服务器
@EnableEurekaServer
public class MainApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MainApplication.class, args);
	}
}
