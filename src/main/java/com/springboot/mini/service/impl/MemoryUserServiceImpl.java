package com.springboot.mini.service.impl;

import com.springboot.mini.model.User;
import com.springboot.mini.service.UserService;
import com.springboot.mini.util.Constants;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * The type Memory user service.
 */
public class MemoryUserServiceImpl implements UserService {

	private static final Map<Long, User> userMapMobile = new HashMap<>();

	@Override
	public void create(@NonNull User user) {
		if(!validate(user))
			throw new IllegalArgumentException(Constants.INVALID_USER_DETAILS);

		if(userMapMobile.containsKey(user.getMobile()))
			throw new IllegalArgumentException(Constants.USER_ALREADY_EXISTS);

		userMapMobile.put(user.getMobile(), user);
        System.out.println(Constants.USER_CREATED_MESSAGE);
	}

	@Override
	public void delete() {

	}

	@Override
	public User findByMobile(Long mobile) {
		Objects.requireNonNull(mobile);
		User user =  userMapMobile.getOrDefault(mobile, null);
        System.out.println(user);
		return user;
	}

	@Override
	public void findByEmail(String email) {

	}

	@Override
	public boolean validate(@NonNull User user) {
		// @TODO:
		// Functions to validate user email & mobile
		return true;
	}
}
