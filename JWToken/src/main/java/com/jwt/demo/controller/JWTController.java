package com.jwt.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.demo.dto.UsersJWTDTO;
import com.jwt.demo.entity.UserJWT;
import com.jwt.demo.service.UserServiceImpl;

@RestController
public class JWTController {

	@Autowired
	UserServiceImpl userService;
	
	@PostMapping("/registernewuser")
	public ResponseEntity<UserJWT> regUser(@RequestBody UserJWT user){
		UserJWT registeredUser = userService.registerUser(user);
		return new ResponseEntity<UserJWT>(registeredUser, HttpStatus.OK);
	}
	
	@PostMapping("/userlogin")
	public  ResponseEntity<UsersJWTDTO> logUser(@RequestBody UserJWT user) throws Exception{
		UsersJWTDTO userToken = userService.loginUser(user);
		return new ResponseEntity<UsersJWTDTO>(userToken, HttpStatus.OK);
	}
	
	@GetMapping("getallusers")
//	public  ResponseEntity<List<User>> getAllRegisteredUsers(@RequestHeader("Authorization") String token){
	public  ResponseEntity<List<UserJWT>> getAllRegisteredUsers(){
		List<UserJWT> usersList = new ArrayList<UserJWT>();
		usersList = userService.viewAllUsers();
		return new ResponseEntity<List<UserJWT>>(usersList, HttpStatus.OK);
	}
	
}
