package com.springboot.mini.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Objects;
import java.util.UUID;

/**
 * The type User.
 */
@Data
public class User {

	private String id = UUID.randomUUID().toString();

	@NonNull
	private String name;

	@NonNull
	private String email;

	// Assuming 10 digits. Can be extended
	@NonNull
	private Long mobile;

	// @TODO
	private String password;

}
