package com.sa.user.service;

import com.sa.user.entity.Users;

public interface UsersServiceInterface {

	
	public Users register(Users users);
	
	public boolean appLogin(Users users);
	
	public Users getUser(String emailId) throws Exception;
}
