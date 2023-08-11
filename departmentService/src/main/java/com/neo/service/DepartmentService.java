package com.neo.service;

import java.util.Optional;

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

	public void deleteDepartmentById(Long deptId) {
		// TODO Auto-generated method stub
	departmentRepo.deleteById(deptId);
	}

	public Optional<Department> findByDeptId(Long deptId) {
		// TODO Auto-generated method stub
		return departmentRepo.findById(deptId);
	}

	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Department updatedDepartment=new Department();
		updatedDepartment=departmentRepo.findById(department.getDeptId()).get();
		updatedDepartment.setDeptAddress(department.getDeptAddress());
		updatedDepartment.setDeptCode(department.getDeptCode());
		updatedDepartment.setDeptId(department.getDeptId());
		updatedDepartment.setDeptName(department.getDeptName());
		Department saveDepartment = departmentRepo.save(updatedDepartment);
		return saveDepartment;
	}
}
