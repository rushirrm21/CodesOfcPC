package com.cts.socialapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UsersService usersService;

	@GetMapping("/register")
	public String registrationPage() {
		return "register";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/logout")
	public String userLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("emailId");
		session.invalidate();
		return "redirect:/login";
	}

	@PostMapping("/registeruser")
	public String registerUser(@ModelAttribute("users") Users users) {
		usersService.register(users);
		return "redirect:/login";
	}

	@PostMapping("/loginuser")
	public String loginUser(@ModelAttribute("users") Users users, HttpServletRequest request, Model model) throws Exception {
		boolean res = usersService.appLogin(users);
		System.out.println(res);
		if (res == true) {
			HttpSession session = request.getSession();
			session.setAttribute("emailId", users.getEmailId());
			return "redirect:/viewallposts";
		}
		model.addAttribute("InvalidCredentials", true);
		throw new Exception("Invalid Credentials");
	}
}
