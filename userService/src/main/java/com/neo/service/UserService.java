package com.neo.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.neo.dto.DepartmentDto;
import com.neo.dto.ResponseDto;
import com.neo.dto.UserDto;
import com.neo.exception.InternalServerException;
import com.neo.model.User;
import com.neo.repo.UserRepo;
import com.neo.util.ServiceUrlUtil;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public ResponseDto findUser(Long userId) throws InternalServerException {
		ResponseEntity<DepartmentDto> responseEntity = null;
		ResponseDto responseDto = new ResponseDto();
		User user = userRepo.findById(userId).get();
		UserDto userDto = mapToUser(user);
		try {
			responseEntity = restTemplate.getForEntity(ServiceUrlUtil.department_Service_Get_URL + user.getDeptId(),
					DepartmentDto.class);
		} catch (Exception e) {
			throw new InternalServerException(
					"here may be have some issue to hit departmentservice to get user with department");
		}
		DepartmentDto departmentDto = responseEntity.getBody();
		responseDto.setDepartment(departmentDto);
		responseDto.setUser(userDto);
		return responseDto;
	}

	
	public UserDto mapToUser(User user) {
		// TODO Auto-generated method stub
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setAddress(user.getAddress());
		userDto.setMobile(user.getMobile());
		userDto.setDeptId(user.getDeptId());
		return userDto;
	}
	

	public String createDepartment(DepartmentDto departmentDto) throws InternalServerException {
		String departmentBody = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<DepartmentDto> entity = new HttpEntity<DepartmentDto>(departmentDto, headers);
		try {
			departmentBody = restTemplate
					.exchange(ServiceUrlUtil.department_Service_Create_URL, HttpMethod.POST, entity, String.class)
					.getBody();
		} catch (Exception e) {
			throw new InternalServerException(
					"here may be have some issue to send the request to departmentservice to create department by user");
		}
		return departmentBody;
	}
	

	public void deleteDepartmentById(Long deptId) throws InternalServerException {

		try {
			restTemplate.delete(ServiceUrlUtil.department_Service_Delete_URL + deptId);
		} catch (Exception e) {
			throw new InternalServerException(
					"here may be have some issue to send the delete request to departmentservice to delete department by user");
		}
	}

	
	public void updateDepartment(DepartmentDto department) throws InternalServerException{
		try {
		restTemplate.put(ServiceUrlUtil.department_Service_Update_URL, department);}
		catch (Exception e) {
			throw new InternalServerException(
					"here may be have some issue to send the update request to departmentservice to update department by user");
		}
	}
	
}
