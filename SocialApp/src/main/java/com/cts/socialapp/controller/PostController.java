package com.cts.socialapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.service.UserPostsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {

	@Autowired
	UserPostsService userPostsService;
	
	@GetMapping("/createpost")
	public String createPost() {
		return "createpost";
	}
	
	@PostMapping("/createpost")
	public String createPost2(@ModelAttribute("posts")UserPosts posts, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String emailId = (String)session.getAttribute("emailId");
		userPostsService.createPost(posts,emailId);
		return "redirect:/viewallposts";
	}
	
	@GetMapping("/viewallposts")
	public String viewAllPostPage(Model model) {
		List<UserPosts> posts = userPostsService.getAllPosts();
		model.addAttribute("posts", posts);
		return "viewallposts";
	}
	
	@GetMapping("/myposts")
	public String viewMyAllPosts(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		String emailId = (String)session.getAttribute("emailId");
		List<UserPosts> posts = userPostsService.getPostsByUserEmailId(emailId);
		model.addAttribute("posts", posts);
		return "myposts";
	}
}
