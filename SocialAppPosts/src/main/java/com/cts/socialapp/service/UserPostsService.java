package com.cts.socialapp.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.socialapp.client.UsersClient;
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.repository.UserPostsRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserPostsService implements UserPostsServiceInterface {

	@Autowired
	UserPostsRepository userPostRepo;

	@Autowired
	UsersClient usersClient;
	@Override
	public UserPosts createPost(UserPosts userPost) throws Exception {
		Users user = usersClient.getUser(userPost.getUserEmailId());
		if(user==null)
		{
			throw new Exception();
		}
		System.out.println(user.getId());
		System.out.println(user.getEmailId());
		System.out.println(user.getLocation());
		System.out.println(user.getUsername());
		userPost.setPostTimestamp(LocalDateTime.now());
		return userPostRepo.save(userPost);
	}

	@Override
	public List<UserPosts> getAllPosts() {
		return userPostRepo.findAll();
	}
}
