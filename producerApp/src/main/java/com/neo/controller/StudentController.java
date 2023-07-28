package com.neo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.neo.model.Student;
import com.neo.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private StudentService studentService;

	@PostMapping("/createStudent")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		boolean isPresent = studentService.findByRollNum(student.getRollNum()).isPresent();
		if (isPresent == true) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Student roll number is already exist so you cannot create this rollnumber student");
		}

		jmsTemplate.convertAndSend("first_queue", student);
		Student createStudent = studentService.createStudent(student);

		return new ResponseEntity<Student>(createStudent, HttpStatus.OK);

	}
	
	
	


	

	

	
}
