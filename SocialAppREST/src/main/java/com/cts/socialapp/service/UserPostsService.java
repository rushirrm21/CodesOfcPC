package com.cts.socialapp.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.socialapp.dto.UserPostsDTO;
import com.cts.socialapp.entity.UserPosts;
import com.cts.socialapp.entity.Users;
import com.cts.socialapp.repository.UserPostsRepository;
import com.cts.socialapp.repository.UsersRepository;
import com.cts.socialapp.util.PostMapper;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserPostsService implements UserPostsServiceInterface {

	@Autowired
	UserPostsRepository userPostRepo;

	@Autowired
	UsersRepository usersRepository;

	@Override
	public void createPost(UserPostsDTO userPost) {
		System.out.println(userPost.getPostTitle());
		System.out.println(userPost.getPostDescription());
		System.out.println(userPost.getUserEmailId());
		Users users = usersRepository.findById(userPost.getUserEmailId()).orElse(null);
		
		UserPosts userPostToDB = new UserPosts();
		userPostToDB.setUsers(users);
		userPostToDB.setPostTimestamp(LocalDateTime.now());
		userPostToDB.setPostTitle(userPost.getPostTitle());
		userPostToDB.setPostDescription(userPost.getPostDescription());
		System.out.println("Service method");
		userPostRepo.save(userPostToDB);
	}

	@Override
	public List<UserPostsDTO> getAllPosts() {
		 List<UserPosts> userPostsList = userPostRepo.findAll();
		 List<UserPostsDTO> output= new ArrayList<>();
		 PostMapper mapper = new PostMapper();
			for( UserPosts e:userPostsList) {
				UserPostsDTO out = mapper.postMapperToDTO(e);
				output.add(out);
			}
			 return output;
	}
}
