package com.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getUsers() {
		System.out.println("Users found: Jyoti, Gurinder, Dan");
		return "/index";
	}
	
	@GetMapping("/") 
	public String getRoot() {
		return "redirect:/index.html";
	}

	
	@GetMapping("/test") 
	public String showAddForm() {
		return "/test";
	}
	
	
}
