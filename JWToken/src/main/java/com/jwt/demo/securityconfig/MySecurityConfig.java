package com.jwt.demo.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import com.jwt.demo.service.UserServiceImpl;


@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfiguration{

	

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UserServiceImpl userServiceImpl;
}
