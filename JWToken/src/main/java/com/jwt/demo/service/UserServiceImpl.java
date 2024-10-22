package com.jwt.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.jwt.demo.dto.UsersJWTDTO;
import com.jwt.demo.entity.UserJWT;
import com.jwt.demo.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UsersRepository userRepository;

	@Override
	public UserJWT registerUser(UserJWT user) {
		userRepository.save(user);
		return user;
	}

	@Override
	public UsersJWTDTO loginUser(UserJWT user) throws Exception {
		UserJWT userFromDB = userRepository.findById(user.getEmailId()).orElse(null);
		if (userFromDB != null && user.getPassword().equalsIgnoreCase(userFromDB.getPassword())) {
			UsersJWTDTO usersJWTDTO = new UsersJWTDTO();
			usersJWTDTO.setEmailId(userFromDB.getEmailId());
			usersJWTDTO.setStatus(true);
			usersJWTDTO.setJwtToken("DEMO");
			return usersJWTDTO;
		}
		throw new Exception("USER NOT FOUND");
	}

	@Override
	public List<UserJWT> viewAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws Exception {
		UserJWT userFromDB = userRepository.findById(userEmail).orElse(null);
		if (userEmail.equalsIgnoreCase(userFromDB.getEmailId())) {
			return new User(userFromDB.getEmailId(), userFromDB.getPassword(), new ArrayList<>());
		}
		else {
		throw new Exception("USER NOT FOUND");
		}
	}
}
