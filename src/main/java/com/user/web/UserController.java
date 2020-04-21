package com.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/index.html")
	public String getIndex() {
		System.out.println("getIndex was called");
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
