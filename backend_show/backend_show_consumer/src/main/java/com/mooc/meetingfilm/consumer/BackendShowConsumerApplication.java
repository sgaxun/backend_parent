package com.mooc.meetingfilm.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * @Desc EnableDiscoveryClient可以集成大部分注册中心,EnableEurekaClient单一 只对eureka使用
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BackendShowConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendShowConsumerApplication.class, args);
	}

}
