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
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.service.UserPostsService;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/socialapp")
public class PostController {

	@Autowired
	UserPostsService userPostsService;
	
	@PostMapping("/createpost")
	public ResponseEntity<UserPosts> createPost(@RequestBody UserPosts  posts) throws Exception {
		System.out.println(posts.getUserEmailId());
		posts = userPostsService.createPost(posts);
		return new ResponseEntity<UserPosts>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/viewallposts")
	public ResponseEntity<List<UserPosts>> viewAllPostPage() {
		List<UserPosts> posts = userPostsService.getAllPosts();
		return new ResponseEntity<List<UserPosts>>(posts,HttpStatus.OK);
	}
}
