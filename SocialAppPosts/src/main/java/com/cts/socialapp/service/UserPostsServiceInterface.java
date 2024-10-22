package com.cts.socialapp.service;

import java.util.List;
import com.cts.socialapp.entity.UserPosts;

public interface UserPostsServiceInterface {

	public UserPosts createPost(UserPosts userPost) throws Exception;

	public List<UserPosts> getAllPosts();
}
