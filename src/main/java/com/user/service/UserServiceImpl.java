package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.domain.User;
import com.user.repository.UserRepository;
import com.user.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	public User login (String user, String password) {
		return new User();
	}
	
	
	public User signup(String user, String password) {
		return new User();	
	}
	
	public Iterable<User> findAll() {
		return repo.findAll();
	}

	
}
