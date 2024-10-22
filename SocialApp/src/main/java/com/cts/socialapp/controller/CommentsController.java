package com.cts.socialapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cts.socialapp.entity.Comments;
import com.cts.socialapp.service.CommentsService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CommentsController {

	@Autowired
	CommentsService commentsService;
	
	Integer postIdForAddComment = null;
	
	@GetMapping("/comments/{postId}")
	public String viewAllPostPage(@PathVariable(value = "postId") int postId, Model model){
		List<Comments> postComments = commentsService.getAllComments(postId);
		postComments.stream().forEach(pc->{
			System.out.println(pc.getCommentId());
			System.out.println(pc.getCommentGiven());
			System.out.println(pc.getCommentTimeStamp());
			System.out.println(pc.getUserPosts().getPostId());
			System.out.println(pc.getUsers().getEmailId());
			System.out.println("-----------");
		});
		model.addAttribute("postComments", postComments);
		postIdForAddComment = postId;
		return "comments";
	}
	
	@GetMapping("/addcomment")
	public String addCommentPage(){
		return "addcomment";
	}
	
	@PostMapping("/addcomment")
	public String addComment(@ModelAttribute("comments") Comments comments, HttpServletRequest request){
		HttpSession session = request.getSession();
		String emailId = (String)session.getAttribute("emailId");
		System.out.println("POST ID : "+postIdForAddComment+"EMail id: "+emailId);
		commentsService.addComment(comments, postIdForAddComment, emailId);
		String redirecTo ="redirect:/comments/"+postIdForAddComment;
		return redirecTo;
	}
}
