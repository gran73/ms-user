package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.user.domain.User;
import com.user.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository repo;

	@GetMapping
	public Iterable<User> getAll() {
		return repo.findAll();
	}
	
	/**
	 * Utility endpoint to view within microservice data locally
	 * 
	 * @return ModelAndView table of user data
	 */
	@GetMapping("/all")
	public ModelAndView getUsers() {
		Iterable<User> list =
				repo.findAll();
			System.out.println("findAllUsers " + list);
			return new ModelAndView("browseUsers",
				 "userList", list);
	}
	
	@GetMapping("/") 
	public String getRoot() {
		return "redirect:/index.html";
	}
	
	
}
