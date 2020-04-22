package com.user.service;

import com.user.domain.User;

public interface UserService {

	public User login (String user, String password);
	public User signup(String user, String password);
	public Iterable<User> findAllUsers();

}
