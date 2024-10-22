package com.cts.socialapp.service;

import com.cts.socialapp.dto.LoginDTO;
import com.cts.socialapp.entity.Users;

public interface UsersServiceInterface {

	
	public Users register(Users users);
	
	public LoginDTO appLogin(Users users)  throws Exception;
}
