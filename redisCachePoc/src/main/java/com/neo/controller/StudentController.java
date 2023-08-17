package com.neo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Student;
import com.neo.repo.StudentRepository;


@RestController
public class StudentController {
@Autowired
	private StudentRepository studentRepo;

@PostMapping("/createStudent")
public void createStudent(@RequestBody Student student) {
	studentRepo.createStudent(student);
}
@GetMapping("/findStudent/{rollNum}")
public Student findStudent(@PathVariable Long rollNum) {
	return studentRepo.findStudent(rollNum);
}

@GetMapping("/findAllStudents")
public Map<String,Student> getAllStudents(){
	return  studentRepo.getAllStudents();
}

@PutMapping("/updateStudent")
public Student updateStudent(@RequestBody Student student) {
return studentRepo.updateStudent(student);
}

@DeleteMapping("/deleteStudent/{rollNum}")
public void  deleteStudent(@PathVariable Long rollNum) {
	studentRepo.deleteStudent(rollNum);
}
}