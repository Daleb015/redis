package com.daleb.redis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.daleb.redis.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private RedisTemplate redisTemplate;

	private static final String KEY = "USER";

	@Override
	public boolean save(User user) {

		try {

			redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<User> fetchAllUser() {

		List<User> users;
		users = redisTemplate.opsForHash().values(KEY);

		return users;
	}

	@Override
	public User fetchUserById(Long id) {
		User user;
		user = (User) redisTemplate.opsForHash().get(KEY, id.toString());
		return user;
	}

}
