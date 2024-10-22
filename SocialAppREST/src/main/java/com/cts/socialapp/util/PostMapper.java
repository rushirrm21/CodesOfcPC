package com.cts.socialapp.util;

import com.cts.socialapp.dto.UserPostsDTO;
import com.cts.socialapp.entity.UserPosts;

public class PostMapper {

	public UserPostsDTO postMapperToDTO(UserPosts userPosts) {
		UserPostsDTO upd = new UserPostsDTO();
		upd.setPostId(userPosts.getPostId());
		upd.setPostTitle(userPosts.getPostTitle());
		upd.setPostDescription(userPosts.getPostDescription());
		upd.setPostTimestamp(userPosts.getPostTimestamp());
		upd.setUserEmailId(userPosts.getUsers().getEmailId());
		return upd;
	}
}
