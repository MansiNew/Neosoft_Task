package com.neo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.exception.PageSizeIsNotValidException;
import com.neo.exception.StudentAlraedyExistException;
import com.neo.exception.StudentNotFoundException;
import com.neo.model.Student;
import com.neo.service.StudentService;

@RestController
public class StudentController {
	@Autowired

	private StudentService studentService;

	@PostMapping("/createStudent")
	public Student createStudent(@RequestBody Student student) {

		return studentService.createStudent(student);
	}

	@GetMapping("findStudentById/{stId}")
	public Optional<Student> findStudentById(@PathVariable Long stId) throws StudentNotFoundException {
		return studentService.findStudentById(stId);
	}

	@GetMapping("findStudentByName")
	public Optional<Student> findStudentBystName(@RequestParam String stName) throws StudentNotFoundException {
		return studentService.findStudentBystName(stName);
	}

	@GetMapping("findStudentPageByRange/{first}/{max}")
	public List<Student> findStudentByPageRange(@PathVariable int first, @PathVariable int max) {
		return studentService.findStudentByPageRange(first, max);
	}

	@GetMapping("findByPage/{pageNumber}/{pageSize}")
	public Page<Student> findStudentsByPage(@PathVariable int pageNumber, @PathVariable int pageSize)
			throws PageSizeIsNotValidException {
		return studentService.findStudentsByPage(pageNumber, pageSize);
	}

	@GetMapping("sortBystNameDesc/{pageNumber}/{pageSize}/{stName}")
	public Page<Student> sortStudentsByNameDecendingOrder(@PathVariable int pageNumber, @PathVariable int pageSize,
			@PathVariable String stName) {
		return studentService.sortStudentsByNameDecendingOrder(pageNumber, pageSize, stName);
	}
}
