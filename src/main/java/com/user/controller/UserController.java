package com.user.controller;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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
	
	@GetMapping("/query")
	public Optional<User> getUserByEmail (@RequestParam String e) {
		Optional<User> user = repo.findbyEmail(e);
		return user;
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
	public ModelAndView defaultView() {
		Iterable<User> list =
				repo.findAll();
			System.out.println("findAllUsers " + list);
			return new ModelAndView("browseUsers",
				 "userList", list);
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody User newUser, UriComponentsBuilder uri){
		if (newUser.getName() == null || newUser.getEmail() == null || newUser.getPassword() == null ) 
		{
			return ResponseEntity.badRequest().build();
		}
		
		newUser = repo.save(newUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").build().toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> UpdateUser(@RequestBody User user, @PathVariable ("userId") long userId){
		if(user.getId() != userId)
		{
			return ResponseEntity.badRequest().build();
		}
		user = repo.save(user);
		return ResponseEntity.ok().build();
		
		
	}
	
	
	
}
