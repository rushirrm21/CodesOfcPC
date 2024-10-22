package com.cts.socialapp.service;

import java.util.List;
import com.cts.socialapp.dto.CommentsDTO;

public interface CommentsServiceInterface {

	public List<CommentsDTO> getAllComments(int postId);
	
	public void addComment(CommentsDTO comments);
}
