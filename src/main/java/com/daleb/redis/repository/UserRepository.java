package com.daleb.redis.repository;

import java.util.List;

import com.daleb.redis.model.User;

public interface UserRepository {
	public boolean save(User user);
	public List<User> fetchAllUser();
	public User fetchUserById(Long id);
}
