package com.jwtda.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsersJWTDTO {

	@Id
	private String emailId;
	private String jwtToken;
	private boolean status;

	
}
