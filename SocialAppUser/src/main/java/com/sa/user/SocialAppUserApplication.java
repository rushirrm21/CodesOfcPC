package com.sa.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SocialAppUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialAppUserApplication.class, args);
	}

}
