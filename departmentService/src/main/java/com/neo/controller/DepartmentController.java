package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Department;
import com.neo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
private DepartmentService departmentService;
	
	@PostMapping("/saveDepartment")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/findDepartmentById/{deptId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("deptId") Long deptId){
        Department department = departmentService.getDepartmentById(deptId);
        return ResponseEntity.ok(department);
    }
}
