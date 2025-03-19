package com.microservice.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.user.service.entity.User;
import com.microservice.user.service.services.UserService;


//this is user service
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@PostMapping(value = "/createUser", consumes = "application/json")
	public ResponseEntity<User> create(@RequestBody User user) {
		User usersave = userservice.userSave(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(usersave);

	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getbyid(@PathVariable String userId) {
		User userget = userservice.getUser(userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(userget);
	}

	
	
	@GetMapping("/getUser")
	public ResponseEntity<List<User>> getall() {
		List<User> list = userservice.getUsers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
