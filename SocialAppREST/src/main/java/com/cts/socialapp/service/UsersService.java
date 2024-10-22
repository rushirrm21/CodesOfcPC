package com.cts.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.socialapp.dto.LoginDTO;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.repository.UsersRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersService implements UsersServiceInterface {

	@Autowired
	UsersRepository userRepo;

	@Override
	public Users register(Users users) {
		userRepo.save(users);
		return users;
	}

	@Override
	public LoginDTO appLogin(Users users) throws Exception {
		Users userFromDB = userRepo.findById(users.getEmailId()).orElse(null);
		LoginDTO loginDTO = new LoginDTO();
		if (userFromDB != null && users.getPassword().equalsIgnoreCase(userFromDB.getPassword())) {
			
			loginDTO.setEmailId(users.getEmailId());
			loginDTO.setLoginValid("True");
			loginDTO.setUserName(userFromDB.getUsername());
			return loginDTO;
			
	}		
			throw new Exception("Invalid Credentials");
	}
}
