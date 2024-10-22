package com.cts.socialapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
