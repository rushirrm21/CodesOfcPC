package com.jwtda.service;

import java.util.List;
import com.jwtda.dto.UsersJWTDTO;
import com.jwtda.entity.UserJWT;


public interface UserService {

	public UserJWT registerUser(UserJWT user);

	public UsersJWTDTO loginUser(UserJWT user) throws Exception;

	public List<UserJWT> viewAllUsers();

}
