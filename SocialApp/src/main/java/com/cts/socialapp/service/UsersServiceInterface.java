package com.cts.socialapp.service;

import com.cts.socialapp.entity.Users;

public interface UsersServiceInterface {

	
	public Users register(Users users);
	
	public boolean appLogin(Users users);
}
