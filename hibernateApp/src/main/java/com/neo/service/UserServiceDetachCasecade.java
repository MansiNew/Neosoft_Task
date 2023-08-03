package com.neo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.config.HibernateConfig;
import com.neo.dao.UserDao;
import com.neo.model.User;

@Service
public class UserServiceDetachCasecade {
	@Autowired
private UserDao userDao;
	@Transactional
	 public void createUser(User user) {
	    userDao.createUser(user);
	    }
	@Transactional
	 public List<User> findAllUser() {
		 return userDao.findAllUser();   
		}
	@Transactional
	 public User findUserById(Long uId) {
		 return userDao.findUserById(uId);
	 }
	@Transactional
	 public void deleteUser(Long uId) {
		userDao.deleteUser(uId); 
		  
	 }
	@Transactional
	 public void updateUser(User user) {
	    	
		 userDao.updateUser(user);
	    }	 
}
