package com.neo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.HospitalDao;
import com.neo.dao.UserDao;
import com.neo.model.Hospital;
import com.neo.model.User;
@Service
public class UserServiceDeleteCasecade {
	@Autowired
	private UserDao userDao;
	@Transactional
	 public void createUser(User user) {
	   userDao.createUser(user);
	    }
	 @Transactional
	 public void deleteUser(Long uId) {
		
		userDao.deleteUser(uId); 
		  
	 }

}
