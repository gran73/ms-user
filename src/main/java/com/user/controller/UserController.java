package com.user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{id}")
	public Optional<User> getUserById (@PathVariable("id") long id) {
		return repo.findById(id);
	}
	
	@GetMapping("/email")
	public Optional<User> getUserByEmail (@RequestParam("email") String email) {
		return repo.findByEmail(email);
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
