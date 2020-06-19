package com.spring.exam.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.exam.sys.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/") 
	public String index() { 
		return "index"; 
	}
	
	@RequestMapping(value="/getAllUsers", method = RequestMethod.GET)
	public String getUsers(ModelMap map) {
		map.addAttribute("users", userService.getUsers());
		return "index";
	}
}
