package com.user.controller;

<<<<<<< HEAD
import java.net.URI;
import java.util.Optional;

//github.com/gran73/ms-user

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//github.com/gran73/ms-user
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
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody User newUser,
			UriComponentsBuilder uri){
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
	public ResponseEntity<?> UpdateUser(@RequestBody User updUser,
			@PathVariable ("userId") long userId){
		if(updUser.getId() != userId)
		{
			return ResponseEntity.badRequest().build();
		}
		updUser = repo.save(updUser);
		return ResponseEntity.ok().build();
		
		
	}
			)
	
	
	
}
