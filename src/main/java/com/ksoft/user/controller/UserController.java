package com.ksoft.user.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksoft.user.model.User;
import com.ksoft.user.service.UserDTO;
import com.ksoft.user.service.UserService;

@RestController
@RequestMapping(value = "/com/ksoft/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping
	private ResponseEntity<User> addUser(User user) {
		userService.addUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@PutMapping
	private ResponseEntity<User> updateUser(User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<User> deleteUserById(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
