package com.cts.socialapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.socialapp.entity.Comments;
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.repository.CommentsRepository;
import com.cts.socialapp.repository.UserPostsRepository;
import com.cts.socialapp.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommentsService implements CommentsServiceInterface {

	@Autowired
	CommentsRepository commentRepo;
	
	@Autowired
	UserPostsRepository userPostRepo;

	@Autowired
	UsersRepository userRepo;
	
	@Override
	public List<Comments> getAllComments(int postId) {
		List<Comments> commentList = commentRepo.findAll();
		List<Comments> provideCommentList = new ArrayList<>();
		if(commentList.isEmpty()) {
			return provideCommentList;
		}
		commentList.stream().forEach(pc->{
			if(pc.getUserPosts().getPostId()==postId) {
				provideCommentList.add(pc);
			}
		});
		return provideCommentList;
		
	}

	@Override
	public void addComment(Comments comments, Integer postIdForAddComment, String userEmailId) {
		comments.setCommentTimeStamp(LocalDateTime.now());
		Users user = userRepo.findById(userEmailId).orElse(null);
		UserPosts userPosts = userPostRepo.findById(postIdForAddComment).orElse(null);
		comments.setUsers(user);
		comments.setUserPosts(userPosts);
		commentRepo.save(comments);
	}
}
