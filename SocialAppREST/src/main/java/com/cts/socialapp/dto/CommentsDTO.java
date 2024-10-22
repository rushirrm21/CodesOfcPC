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
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentsDTO {

	private int commentId;
	private String commentGiven;
	private LocalDateTime commentTimeStamp;
	private String userEmailId;
	private int postId;
}
