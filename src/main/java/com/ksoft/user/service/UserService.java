package com.ksoft.user.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksoft.user.dao.UserDAO;
import com.ksoft.user.model.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	public void addUser(User user) {
		try {
			
			userDAO.adduser(user);
		}catch(EntityExistsException e){
			System.out.println("Entity already exists in DB");
		}catch(IllegalArgumentException ex) {
			System.out.println("Illegal arguments were passed");
		}
	}
	
	public void updateUser(User user) {
		try {
			userDAO.updateUser(user);
		}catch(EntityExistsException e){
			System.out.println("Entity already exists in DB");
		}catch(IllegalArgumentException ex) {
			System.out.println("Illegal arguments were passed");
		}
	}
	
	public void deleteUser(int id) {
		try {
			userDAO.deleteUser(id);
		}catch(IllegalArgumentException ex) {
			System.out.println("Illegal arguments were passed");
		}
	}
}
