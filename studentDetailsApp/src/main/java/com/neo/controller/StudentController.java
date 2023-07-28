package com.neo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.neo.model.Student;
import com.neo.serviceImpl.StudentServiceImpl;

@RestController
public class StudentController {
	@Autowired
	private StudentServiceImpl studentService;

	@PostMapping("/createStudent")
	public ResponseEntity<?> createStudent(@RequestBody Student student) {
		boolean isPresent = studentService.findByRollNum(student.getRollNum()).isPresent();
		if (isPresent == true) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Student roll number is already exist so you cannot create this rollnumber student");
		}
		Student createStudent = studentService.createStudent(student);
		return new ResponseEntity<Student>(createStudent, HttpStatus.OK);

	}

	@GetMapping("/allStudents")
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> studentsList = studentService.findAllStudents();
		if (studentsList.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);

		}
		List<Student> findAllStudents = studentService.findAllStudents();
		return new ResponseEntity<List<Student>>(findAllStudents, HttpStatus.OK);
	}

	@GetMapping("/findStudent/{rollNum}")
	public ResponseEntity<?> findByRollNum(@PathVariable("rollNum") long rollNum) {
		Optional<Student> findByRollNum = studentService.findByRollNum(rollNum);
		if (!findByRollNum.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student roll number is not present ");

		}
		return new ResponseEntity<Optional<Student>>(findByRollNum, HttpStatus.OK);
	}

	@DeleteMapping("deleteStudent/{rollNum}")
	public ResponseEntity<?> deleteStudent(@PathVariable("rollNum") long rollNum) {
		if (!studentService.findByRollNum(rollNum).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Student roll number is not present so you cannot delete");
		}
		String deleteStudent = studentService.deleteStudent(rollNum);
		return new ResponseEntity<String>(deleteStudent, HttpStatus.OK);
	}

	@PutMapping("/updateStudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student request) {
		boolean isPresent = studentService.findByRollNum(request.getRollNum()).isPresent();
		if (isPresent == false) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Student roll number is not present so please enter valid rollnumber");
		}
		Student updateStudent = studentService.updateStudent(request);
		return new ResponseEntity<Student>(updateStudent, HttpStatus.OK);
	}
}
