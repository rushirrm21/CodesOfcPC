package com.cts.socialapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cts.socialapp.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

//	@Query("select c from Comments c where c.postId=?1")
//	public List<Comments> getAllCommentsOnSpecificPost(int postId);
	
}
