package com.cts.socialapp.service;

import java.util.List;
import com.cts.socialapp.entity.UserPosts;

public interface UserPostsServiceInterface {

	public UserPosts createPost(UserPosts userPost, String emailId);

	public List<UserPosts> getAllPosts();

	public List<UserPosts> getPostsByUserEmailId(String emailId);
}
