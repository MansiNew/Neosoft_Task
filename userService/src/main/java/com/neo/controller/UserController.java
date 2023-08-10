package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.ResponseDto;
import com.neo.model.User;
import com.neo.service.UserService;

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
	public ResponseEntity<ResponseDto> findUser(@PathVariable("userId") Long userId) {
		System.out.println("hello resttemplate");
		ResponseDto userResponseDto = userService.findUser(userId);
		return ResponseEntity.ok(userResponseDto);
	}
}
