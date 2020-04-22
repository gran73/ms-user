package com.user.controller;

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
	public ModelAndView getUsers() {
		Iterable<User> list =
				userService.findAllUsers();
			System.out.println("findAllUsers " + list);
			return new ModelAndView("browseUsers",
				 "userList", list);
	}
	
	@GetMapping("/") 
	public String getRoot() {
		return "redirect:/index.html";
	}
	
}
