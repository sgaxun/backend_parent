package com.mooc.meetingfilm.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @Desc EnableDiscoveryClient可以集成大部分注册中心,EnableEurekaClient单一 只对eureka使用
 */
@EnableDiscoveryClient
@SpringBootApplication
public class BackendShowProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendShowProviderApplication.class, args);
	}

}
