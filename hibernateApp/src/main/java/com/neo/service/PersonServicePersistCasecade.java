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
public class PersonServicePersistCasecade {
	@Autowired
private PersonDao personDao;
	@Transactional
	 public void createPersonByPersist(Person person) {
    	personDao.createPersonByPersist(person);
	    }
	@Transactional
	 public void createPersonBySave(Person person) {
	    personDao.createPersonBySave(person);	
		 
	    }
}
