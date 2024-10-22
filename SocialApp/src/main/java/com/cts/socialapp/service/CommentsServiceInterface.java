package com.cts.socialapp.service;

import java.util.List;

import com.cts.socialapp.entity.Comments;

public interface CommentsServiceInterface {

	public List<Comments> getAllComments(int postId);
	
	public void addComment(Comments comments, Integer postIdForAddComment, String userEmailId);
}
