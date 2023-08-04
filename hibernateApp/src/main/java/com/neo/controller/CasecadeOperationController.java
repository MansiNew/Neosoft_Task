package com.neo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Hospital;
import com.neo.model.Person;
import com.neo.model.Student;
import com.neo.model.User;
import com.neo.service.HospitalServiceRefreshCasecade;
import com.neo.service.PersonServiceMergeCasecade;
import com.neo.service.ProductServiceDetachCasecade;
import com.neo.service.StudentServicePersistCaseCade;
import com.neo.service.UserServiceDeleteCasecade;

@RestController
public class CasecadeOperationController {
	@Autowired
	private StudentServicePersistCaseCade studentService;

	@Autowired
	private UserServiceDeleteCasecade userService;
	@Autowired
	private PersonServiceMergeCasecade personService;
	@Autowired
	private ProductServiceDetachCasecade productService;

	@PostMapping("/createStudentPersist")
	public void createAddress(@RequestBody Student student) {
		System.out.println(student.getSchool().getName());
		studentService.createStudent(student);
	}

	@PutMapping("/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return "it will not update data in child because casecade type is persist ";
	}

	@PostMapping("/updatePersonMerge")
	public void updatePerson(@RequestBody Person person) {
		System.out.println(person.getAccount().getClass().toString());
		personService.updatePerson(person);
	}

	@PostMapping("/createPerson")
	public String createPerson(@RequestBody Person person) {
		personService.createPerson(person);
		return "data will not save in account entity direct because here merge casecade operation is used";
	}

	@PostMapping("/createUser")
	public String StringcreateUser(@RequestBody User user) {
		userService.createUser(user);
		return "data will not created in user entity direct because here remove casecade operation is used";
	}

	@DeleteMapping("/deleteUserRemove/{uId}")
	public void deleteUser(@PathVariable Long uId) {
		userService.deleteUser(uId);
	}

	@DeleteMapping("/deleteProductDetach/{prId}")
	public void deleteProduct(@PathVariable Long prId) {
		productService.detachProduct(prId);
	}
}
