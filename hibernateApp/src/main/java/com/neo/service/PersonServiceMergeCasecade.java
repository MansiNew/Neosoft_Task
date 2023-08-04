package com.neo.service;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.config.HibernateConfig;
import com.neo.dao.PersonDao;
import com.neo.model.Person;

@Service 
public class PersonServiceMergeCasecade {
	@Autowired
private PersonDao personDao;
	@Transactional
	 public void updatePerson(Person person) {
	    personDao.updatePerson(person);	
		  
	    }	
	 @Transactional
	 public void createPerson(Person person) {
	    	
		  personDao.createPerson(person); 
	    }
}
