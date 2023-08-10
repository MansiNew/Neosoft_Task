package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

}
