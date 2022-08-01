package com.ksoft.user.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ksoft.user.model.User;
import com.ksoft.user.service.UserDTO;

@Repository
public class UserDAO {

	@Autowired
	EntityManager em;
	
	@Transactional
	public List<User> getAllUsers(){
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	@Transactional
	public void adduser(User user) {
		em.persist(user);
	}
	
	@Transactional
	public void updateUser(User user) {
		User existUser = em.find(User.class, user.getId());
		if(existUser != null) {
			existUser.setName(user.getName());
			em.persist(existUser);
		}
	}
	
	@Transactional
	public void deleteUser(int id) {
		User user = em.find(User.class, id);
		if(user != null) {
			em.remove(user);
		}
	}
}
