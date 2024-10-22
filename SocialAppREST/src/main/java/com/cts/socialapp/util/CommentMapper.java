package com.cts.socialapp.util;

import com.cts.socialapp.dto.CommentsDTO;
import com.cts.socialapp.entity.Comments;

public class CommentMapper {

	public CommentsDTO commenttMapperToDTO(Comments comments) {
		CommentsDTO upd = new CommentsDTO();
		upd.setCommentId(comments.getCommentId());
		upd.setCommentGiven(comments.getCommentGiven());
		upd.setCommentTimeStamp(comments.getCommentTimeStamp());
		upd.setPostId(comments.getUserPosts().getPostId());
		upd.setUserEmailId(comments.getUsers().getEmailId());
		return upd;
	}

}
