package com.cts.socialapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.socialapp.entity.Users;

@FeignClient(value="socialappuser" , url="http://localhost:8084/socialapp")
public interface UsersClient {

	@GetMapping("/getuserbyemailid/{emailId}")
	public Users getUser(@RequestParam("emailId")String emailId)throws Exception;

}
