package com.neo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.model.Department;
import com.neo.repo.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	public Department saveDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	 public Department getDepartmentById(Long deptId) {
	        return departmentRepo.findById(deptId).get();
	    }
}
