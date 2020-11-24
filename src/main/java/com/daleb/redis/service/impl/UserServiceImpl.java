package com.daleb.redis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daleb.redis.model.User;
import com.daleb.redis.repository.UserRepository;
import com.daleb.redis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> fetchAllUser() {
		
		return userRepository.fetchAllUser();
	}

	@Override
	public User fetchUserById(Long id) {
		return userRepository.fetchUserById(id);
	}

}
