package com.jwtda.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.jwtda.dto.ErrorResponse;
import com.jwtda.dto.UsersJWTDTO;
import com.jwtda.entity.UserJWT;
import com.jwtda.repository.UsersRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService{
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UsersRepository userRepository;

	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
	
	@Override
	public UserJWT registerUser(UserJWT user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	@Override
	public UsersJWTDTO loginUser(UserJWT user) throws Exception {
		UserJWT userFromDB = userRepository.findById(user.getEmailId()).orElse(null);
		
//		if (userFromDB != null && user.getPassword().equalsIgnoreCase(userFromDB.getPassword())) {
		if (userFromDB != null && passwordEncoder().matches(user.getPassword(), userFromDB.getPassword())) {
			UsersJWTDTO usersJWTDTO = new UsersJWTDTO();
			usersJWTDTO.setEmailId(userFromDB.getEmailId());
			usersJWTDTO.setStatus(true);
			usersJWTDTO.setJwtToken("DEMO");
			return usersJWTDTO;
		}
		 ErrorResponse errorResponse = new ErrorResponse();
	     errorResponse.setMsg("Invalid Credentials, generation exception in next statement");
	     errorResponse.setCode(404);
	     logger.info("Error:{}",errorResponse);
	     logger.error("Error:{}",errorResponse);
		throw new Exception("USER NOT FOUND");
	}

	@Override
	public List<UserJWT> viewAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) {
		UserJWT userFromDB = userRepository.findById(userEmail).orElse(null);
		if (userEmail.equalsIgnoreCase(userFromDB.getEmailId())) {
			return new User(userFromDB.getEmailId(), userFromDB.getPassword(), new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("USER NOT FOUND !");
		}
	}
}

