package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.EmployeeAddress;

public interface EmployeeAddressRepo extends JpaRepository<EmployeeAddress,Long> {

}
