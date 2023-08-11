package com.neo.controller;

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

import com.neo.dto.DepartmentDto;
import com.neo.dto.ResponseDto;
import com.neo.exception.InternalServerException;
import com.neo.model.User;
import com.neo.service.UserService;
import com.neo.util.ServiceUrlUtil;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/findUserWithDepartment/{userId}")
	public ResponseEntity<ResponseDto> findUser(@PathVariable("userId") Long userId) throws InternalServerException {
		System.out.println("hello resttemplate");
		ResponseDto userResponseDto = userService.findUser(userId);
		return ResponseEntity.ok(userResponseDto);
	}
	
	@PostMapping("/saveDepartmentByUser")
	 public String createDepartment(@RequestBody DepartmentDto departmentDto) throws InternalServerException {
		return userService.createDepartment(departmentDto);
		
	}
	@DeleteMapping("/deleteDepartmentByUser/{deptId}")
	public void deleteDepartmentById(@PathVariable("deptId") Long deptId) throws InternalServerException {
		userService.deleteDepartmentById(deptId);
	}
	
	@PutMapping("/updateDepartmentByUser")
	public void updateDepartmentByUser(@RequestBody DepartmentDto department) throws InternalServerException {
	userService.updateDepartment(department);		 
	}
}
