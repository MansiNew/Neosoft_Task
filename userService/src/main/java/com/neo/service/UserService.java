package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.neo.dto.DepartmentDto;
import com.neo.dto.ResponseDto;
import com.neo.dto.UserDto;
import com.neo.model.User;
import com.neo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	 public User saveUser(User user) {
		 return userRepo.save(user);
	 }
	 
	 public ResponseDto findUser(Long userId) {
		 
		 ResponseDto responseDto = new ResponseDto();
	        User user = userRepo.findById(userId).get();
	        UserDto userDto = mapToUser(user);
	        ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:3032/findDepartmentById/"+user.getDeptId(), DepartmentDto.class);
	DepartmentDto departmentDto = responseEntity.getBody();
	responseDto.setDepartment(departmentDto);
	responseDto.setUser(userDto);
	return responseDto;
	 }

	public UserDto mapToUser(User user) {
		// TODO Auto-generated method stub
		UserDto userDto=new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setAddress(user.getAddress());
		userDto.setMobile(user.getMobile());
		userDto.setDeptId(user.getDeptId());
		return userDto;
	}
}
