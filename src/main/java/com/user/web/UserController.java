package com.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.domain.User;
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

	
	@RequestMapping("/browse")
	public ModelAndView browseUsers() {
		Iterable<User> list =
			userService.findAllUsers();
		return new ModelAndView("browseUsers",
			 "userList", list);
	}
	
	
}
