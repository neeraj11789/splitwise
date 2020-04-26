package com.springboot.mini.service;

import com.springboot.mini.model.User;

/**
 * The interface User service.
 */
public interface UserService {

	/**
	 * Create.
	 *
	 * @param user the user
	 */
void create(User user);

	/**
	 * Delete.
	 */
void delete();

	/**
	 * Find by mobile user.
	 *
	 * @param mobile the mobile
	 * @return the user
	 */
User findByMobile(Long mobile);

	/**
	 * Find by email.
	 *
	 * @param email the email
	 */
void findByEmail(String email);

	/**
	 * Validate boolean.
	 *
	 * @param user the user
	 * @return the boolean
	 */
boolean validate(User user);
}