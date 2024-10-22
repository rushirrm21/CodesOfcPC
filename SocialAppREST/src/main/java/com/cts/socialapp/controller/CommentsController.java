package com.cts.socialapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.socialapp.dto.CommentsDTO;
import com.cts.socialapp.service.CommentsService;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/socialapp")
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	@Autowired
	UserController userController;

	Integer postIdForAddComment = null;

	@GetMapping("/comments/{postId}")
	public ResponseEntity<List<CommentsDTO>> viewAllCommentsOnPost(@PathVariable("postId") int postId) {
		System.out.println("IN view all post page");
		List<CommentsDTO> postComments = commentsService.getAllComments(postId);
		return new ResponseEntity<List<CommentsDTO>>(postComments,HttpStatus.OK);
	}

	@PostMapping("/addcomment")
	public ResponseEntity<CommentsDTO>addComment(@RequestBody CommentsDTO comments) {
		System.out.println("In add COmment");
		comments.setUserEmailId(userController.getLoggedInUser());
		System.out.println(comments.getCommentGiven());
		System.out.println(comments.getCommentTimeStamp());
		System.out.println(comments.getUserEmailId());
		System.out.println(comments.getPostId());
		commentsService.addComment(comments);
		return new ResponseEntity<CommentsDTO>(comments, HttpStatus.OK);
		
	}
}
