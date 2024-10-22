package com.jwt.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.jwt.demo.dto.UsersJWTDTO;
import com.jwt.demo.entity.UserJWT;

public interface UserService {

	public UserJWT registerUser(UserJWT user);

	public UsersJWTDTO loginUser(UserJWT user) throws Exception;

	public List<UserJWT> viewAllUsers();
	
	public UserDetails loadUserByUsername(String userEmail) throws Exception;
}
