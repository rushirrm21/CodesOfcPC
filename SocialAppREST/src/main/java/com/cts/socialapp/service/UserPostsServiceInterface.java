package com.cts.socialapp.service;

import java.util.List;
import com.cts.socialapp.dto.UserPostsDTO;

public interface UserPostsServiceInterface {

	public void createPost(UserPostsDTO userPost);

	public List<UserPostsDTO> getAllPosts();

}
