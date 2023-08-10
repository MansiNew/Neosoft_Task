package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long> {

}
