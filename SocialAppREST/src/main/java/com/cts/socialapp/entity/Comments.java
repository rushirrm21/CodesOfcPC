package com.cts.socialapp.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	private String commentGiven;
	private LocalDateTime commentTimeStamp;

	@ManyToOne
	@JoinColumn(name = "userId")
	private Users users;

	@ManyToOne
	@JoinColumn(name = "postId")
	private UserPosts userPosts;

}
