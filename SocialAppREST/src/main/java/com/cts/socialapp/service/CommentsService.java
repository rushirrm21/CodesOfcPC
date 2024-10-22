package com.cts.socialapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.socialapp.dto.CommentsDTO;
import com.cts.socialapp.dto.UserPostsDTO;
import com.cts.socialapp.entity.Comments;
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.repository.CommentsRepository;
import com.cts.socialapp.repository.UserPostsRepository;
import com.cts.socialapp.repository.UsersRepository;
import com.cts.socialapp.util.CommentMapper;

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
	public List<CommentsDTO> getAllComments(int postId) {
		List<Comments> commentList = commentRepo.findAll();
		List<Comments> provideCommentList = new ArrayList<>();
		List<CommentsDTO> provideCommentListToController = new ArrayList<>();
		if(commentList.isEmpty()) {
			return provideCommentListToController;
		}
		commentList.stream().forEach(pc->{
			if(pc.getUserPosts().getPostId()==postId) {
				provideCommentList.add(pc);
			}
		});
		CommentMapper cm = new CommentMapper();
		for( Comments c: provideCommentList) {
			CommentsDTO out = cm.commenttMapperToDTO(c);
			provideCommentListToController.add(out);
		}
		return provideCommentListToController;
		
	}

	@Override
	public void addComment(CommentsDTO comments) {
		Comments com = new Comments();
		comments.setCommentTimeStamp(LocalDateTime.now());
		Users user = userRepo.findById(comments.getUserEmailId()).orElse(null);
		UserPosts userPosts = userPostRepo.findById(comments.getPostId()).orElse(null);
		com.setUsers(user);
		com.setUserPosts(userPosts);
		com.setCommentGiven(comments.getCommentGiven());
		com.setCommentTimeStamp(comments.getCommentTimeStamp());
		commentRepo.save(com);
	}
}
