package com.sa.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sa.user.entity.Users;
import com.sa.user.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsersService implements UsersServiceInterface {

	@Autowired
	UsersRepository userRepo;

	@Override
	public Users register(Users users) {
		Users userFromDB = userRepo.save(users);
		return userFromDB;
	}

	@Override
	public boolean appLogin(Users users) {
		Users userFromDB = userRepo.findById(users.getEmailId()).orElse(null);
		if (userFromDB != null && users.getPassword().equalsIgnoreCase(userFromDB.getPassword()))
			return true;
		return false;
	}

	@Override
	public Users getUser(String emailId) throws Exception {
		Users user = userRepo.findById(emailId).orElse(null);
		if(user==null)
			throw new Exception("User not found");
		return user;
	}
}
