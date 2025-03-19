package com.microservice.user.service.services;

import java.util.List;

import com.microservice.user.service.entity.User;

public interface UserService {
	User userSave(User user);

	List<User> getUsers();

	User getUser(String userId);

}
