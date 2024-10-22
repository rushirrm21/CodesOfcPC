package com.sa.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sa.user.entity.Users;
import com.sa.user.service.UsersService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/socialapp")
public class UserController {

	@Autowired
	UsersService usersService;

	@PostMapping("/registeruser")
	public ResponseEntity<Users> registerUser(@RequestBody Users users) {
		System.out.println(users.getEmailId());
		System.out.println(users.getPassword());
		System.out.println(users.getUsername());
		System.out.println(users.getLocation());
		Users userRegistered = usersService.register(users);
		return new ResponseEntity<Users>(userRegistered,HttpStatus.OK);
	}

	@PostMapping("/loginuser")
	public ResponseEntity<Users> loginUser(@RequestBody Users users, HttpServletRequest request) throws Exception {
		System.out.println(users.getEmailId());
		System.out.println(users.getPassword());
		boolean res = usersService.appLogin(users);
		System.out.println(res);
		if (res == true) {
			HttpSession session = request.getSession();
			session.setAttribute("emailId", users.getEmailId());
			return new ResponseEntity<Users>(users,HttpStatus.OK);
		}
		throw new Exception("Invalid Credentials");
	}
	
	@GetMapping("getuserbyemailid/{emailId}")
	public ResponseEntity<Users> getUser(@RequestParam("emailId")String emailId) throws Exception {
		Users user = usersService.getUser(emailId);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
}

