package com.neo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Person;
import com.neo.model.User;
import com.neo.service.PersonServicePersistCasecade;
import com.neo.service.UserServiceDetachCasecade;

@RestController
public class CasecadeOperationController {
	@Autowired
private PersonServicePersistCasecade personService;
	@Autowired
	private UserServiceDetachCasecade userService;
	@PostMapping("/createPersonPersist")
	 public ResponseEntity<String> createPersonByPersist(@RequestBody Person person) {
	    	personService.createPersonByPersist(person);
	    	return ResponseEntity.status(HttpStatus.OK)
					.body("person is created successfully by persist method so it will  affect child class data because persist casecade operation");}
		    
	@PostMapping("/createPersonSave")
		 public ResponseEntity<String> createPersonBySave(@RequestBody Person person) {
		    personService.createPersonBySave(person);	
		    return ResponseEntity.status(HttpStatus.OK)
					.body("person is created successfully by save method so it will not affect child class data");}
		    
@PostMapping("/createUserDetach")
public ResponseEntity<String> createUser(@RequestBody User user) {
   userService.createUser(user);
   	return ResponseEntity.status(HttpStatus.OK)
				.body("user is created successfully for detach casecade operation");}}
	    
