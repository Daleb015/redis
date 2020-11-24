package com.daleb.redis.service;

import java.util.List;

import com.daleb.redis.model.User;

public interface UserService {
	public boolean saveUser(User user);
	public List<User> fetchAllUser();
	public User fetchUserById(Long id);
}
