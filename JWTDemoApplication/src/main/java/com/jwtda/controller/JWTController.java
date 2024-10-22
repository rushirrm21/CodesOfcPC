package com.jwtda.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jwtda.dto.ErrorResponse;
import com.jwtda.dto.UsersJWTDTO;
import com.jwtda.entity.UserJWT;
import com.jwtda.security.JwtHelper;
import com.jwtda.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class JWTController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;

	Logger logger = LoggerFactory.getLogger(JWTController.class);
	
	@PostMapping("/registernewuser")
	public ResponseEntity<UserJWT> regUser(@RequestBody UserJWT user) {
		logger.info("We are in regUser method called by postMapping /registeruser");
		UserJWT registeredUser = userService.registerUser(user);
		logger.info("User is regitered returning response");
		 ErrorResponse errorResponse = new ErrorResponse();
	     errorResponse.setMsg("Just Checking error logs");
	     errorResponse.setCode(404);
	     logger.error("Error:{}",errorResponse);
		return new ResponseEntity<UserJWT>(registeredUser, HttpStatus.OK);
	}

	@PostMapping("/userlogin")
	public ResponseEntity<UsersJWTDTO> logUser(@RequestBody UserJWT user) throws Exception {
//		UsersJWTDTO userToken = userService.loginUser(user);
		this.doAuthenticate(user.getEmailId(), user.getPassword());
		logger.info("We are in logUser method called by postMapping /userlogin");
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmailId());
		String token = this.helper.generateToken(userDetails);

		UsersJWTDTO response = UsersJWTDTO.builder().jwtToken(token).emailId(userDetails.getUsername()).status(true).build();
		logger.info("User is logged in returning response");
		return new ResponseEntity<>(response, HttpStatus.OK);
//		return new ResponseEntity<UsersJWTDTO>(userToken, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

	@GetMapping("/getallusers")
	public  ResponseEntity<List<UserJWT>> getAllRegisteredUsers(@RequestHeader("Authorization") String token){
//	public ResponseEntity<List<UserJWT>> getAllRegisteredUsers() {
		List<UserJWT> usersList = new ArrayList<UserJWT>();
		usersList = userService.viewAllUsers();
		return new ResponseEntity<List<UserJWT>>(usersList, HttpStatus.OK);
	}

}
