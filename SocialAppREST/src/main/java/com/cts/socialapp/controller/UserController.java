package com.cts.socialapp.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.socialapp.dto.LoginDTO;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.service.UsersService;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/socialapp")
public class UserController {

	@Autowired
	UsersService usersService;
	
	String loggedInUser = null;

	@PostMapping("/registeruser")
	public ResponseEntity<Users> registerUser(@RequestBody Users users) {
		System.out.println(users.getEmailId());
		System.out.println(users.getPassword());
		System.out.println(users.getUsername());
		System.out.println(users.getLocation());
		Users userRegistered = usersService.register(users);
		System.out.println(userRegistered.getEmailId());
		System.out.println(userRegistered.getPassword());
		System.out.println(userRegistered.getUsername());
		System.out.println(userRegistered.getLocation());
		return new ResponseEntity<Users>(userRegistered, HttpStatus.OK);
	}

	@PostMapping("/loginuser")
	public  ResponseEntity<LoginDTO> loginUser(@RequestBody Users users) throws Exception {
		System.out.println(users.getEmailId());
		System.out.println(users.getPassword());
		LoginDTO loginDTO = usersService.appLogin(users);
	
			return new ResponseEntity<LoginDTO>(loginDTO, HttpStatus.OK);
		
	}
	
	public String getLoggedInUser() {
		return loggedInUser;
	}
}
