package com.jwt.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersJWTDTO {

	private String emailId;
	private String jwtToken;
	private boolean status;

}
