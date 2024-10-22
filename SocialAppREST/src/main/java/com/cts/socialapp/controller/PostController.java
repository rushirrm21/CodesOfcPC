package com.cts.socialapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.socialapp.dto.UserPostsDTO;
import com.cts.socialapp.service.UserPostsService;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/socialapp")
public class PostController {

	@Autowired
	UserPostsService userPostsService;
	

	@Autowired
	UserController userController;

	@PostMapping("/createpost")
	public ResponseEntity<UserPostsDTO> createPost(@RequestBody UserPostsDTO posts) {
		System.out.println(posts.getPostTitle());
		System.out.println(posts.getPostDescription());
		System.out.println(posts.getUserEmailId());
//		posts.setUserEmailId(userController.getLoggedInUser());
		userPostsService.createPost(posts);
		return new ResponseEntity<UserPostsDTO>(posts, HttpStatus.OK);
	}

	@GetMapping("/viewallposts")
	public ResponseEntity<List<UserPostsDTO>> viewAllPostPage() {
		List<UserPostsDTO> posts = userPostsService.getAllPosts();
		return new ResponseEntity<List<UserPostsDTO>>(posts,HttpStatus.OK);
	}
}
