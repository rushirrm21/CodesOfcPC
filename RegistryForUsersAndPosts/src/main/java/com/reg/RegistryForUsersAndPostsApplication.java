package com.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryForUsersAndPostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryForUsersAndPostsApplication.class, args);
	}

}
