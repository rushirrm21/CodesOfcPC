package com.cts.socialapp.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserPostsDTO {

	private int postId;
	private String postTitle;
	private String postDescription;
	private LocalDateTime postTimestamp;
	private String userEmailId;

}