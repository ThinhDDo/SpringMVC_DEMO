package com.spring.exam.sys.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.exam.sys.model.User;
import com.spring.exam.sys.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/") 
	public String index() { 
		return "index";
	}
	
	@GetMapping(value="/getAllUsers")
	public String getUsers(ModelMap map) {
		map.addAttribute("userForSearch", new User());
		map.addAttribute("users", userService.getUsers());
		return "main_page";
	}
	
	@PostMapping(value="/search")
	public String search(@ModelAttribute User userForSearch, ModelMap map) {
		if(userForSearch.getName().equals("") && userForSearch != null) {
			// Display alert box
			return "redirect:/getAllUsers";
		}
		
		map.addAttribute("userForSearch", userForSearch);
		map.addAttribute("users", userService.getUsersByName(userForSearch.getName()));
		return "main_page";
	}
	
	@GetMapping(value="/add")
	public String add_showForm(Model model) {
		
		model.addAttribute("user", new User("user-" + UUID.randomUUID().toString(), ""));
		return "add";
	}
	
	@PostMapping(value="/save")
	public String add(@ModelAttribute User user) {
		
		userService.addUser(user);
		return "redirect:/getAllUsers";
	}
	
	@GetMapping(value="/update")
	public String update(@RequestParam("id") String id, Model model) {
		
		User user = userService.getUserById(id);
		if(user==null) {
			return "/getAllUsers";
		}
		
		model.addAttribute("user", user);
		return "update";
	}
	
	@PostMapping(value="update-save")
	public String updateSave(@ModelAttribute User user) {
		userService.updateUser(user);
		return "redirect:/getAllUsers";
	}
	
	@GetMapping(value="delete")
	public String delete(@RequestParam("id") String id) {
		User user = userService.getUserById(id);
		if(user==null) {
			return "/getAllUsers";
		}
		
		userService.deleteUser(id);
		return "redirect:/getAllUsers";
	}
}
