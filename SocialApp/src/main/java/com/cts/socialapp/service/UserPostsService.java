package com.cts.socialapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.repository.UserPostsRepository;
import com.cts.socialapp.repository.UsersRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserPostsService implements UserPostsServiceInterface {

	@Autowired
	UserPostsRepository userPostRepo;

	@Autowired
	UsersRepository usersRepository;

	@Override
	public UserPosts createPost(UserPosts userPost, String emailId) {
		Users users = usersRepository.findById(emailId).orElse(null);
		userPost.setUsers(users);
		userPost.setPostTimestamp(LocalDateTime.now());
		return userPostRepo.save(userPost);
	}

	@Override
	public List<UserPosts> getAllPosts() {
		return userPostRepo.findAll();
	}

	@Override
	public List<UserPosts> getPostsByUserEmailId(String emailId) {
		List<UserPosts> provideUserPosts = new ArrayList<>();
		List<UserPosts> userPosts = getAllPosts();
		userPosts.stream().forEach(up->{
			if(up.getUsers().getEmailId().equalsIgnoreCase(emailId)) {
				provideUserPosts.add(up);
			}
		});
		return provideUserPosts;	
	}
}
