package com.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufc.entity.User;
import com.ufc.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ufc/v1")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/user")
	public User addUser (@RequestBody User user) {
		try {
			return userService.createUser(user);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/user/{id}")
	public User addUser (@PathVariable Long id) {
		try {
			return userService.getUserById(id);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@GetMapping("/user")
	public List<User> getAllUsers () {
		try {
			return userService.getAllUser();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/user/{id}")
	public Integer delteUser (@PathVariable Long id) {
		try {
			return userService.deleteUser(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
