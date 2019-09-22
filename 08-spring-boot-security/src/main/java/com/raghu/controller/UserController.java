package com.raghu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.model.User;

@RestController
public class UserController {

	@RequestMapping("/user")
	public User getUser() {
		return new User("Raghu", "raghu");
	}
	
}
