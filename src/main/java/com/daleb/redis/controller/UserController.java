package com.daleb.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daleb.redis.model.User;
import com.daleb.redis.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		if (userService.saveUser(user)) {
			return ResponseEntity.ok("User created successfull");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@GetMapping("/user")
	public ResponseEntity<List<User>> fetchAllUser(){
		List<User> users;
		users = userService.fetchAllUser();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable("id") Long id){
		User user;
		user = userService.fetchUserById(id);
		return ResponseEntity.ok(user);
		
	}
}
