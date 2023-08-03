
 package com.neo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.EmployeeDao;
import com.neo.model.Employee;

@Service
public class EmployeeServie {
	@Autowired
	private EmployeeDao empDao;
		@Transactional
		public void createEmployee(Employee employee) {
			empDao.createEmployee(employee);
		}
		@Transactional
		 public List<Employee> findAllEmployee(){
			return empDao.findAllEmployee();
		}
		@Transactional
		public Employee findEmployeeById(Long empId) {
			return empDao.findEmployeeById(empId);
		}
		@Transactional
		public void deleteEmployee(Long empId) {
			empDao.deleteEmployee(empId);
		}
		@Transactional
		 public void updateEmployee(Employee employee) {
			 empDao.updateEmployee(employee);
		 }
		@Transactional
		 public List<Employee> findAllEmployeeByCriteriaQuery(){
			return empDao.findAllEmployeeByCriteriaQuery();
		}
		@Transactional
		 public List<Employee> findEmployeeWhoseSalaryIsHigherThan2000(){
			return empDao.findEmployeeWhoseSalaryIsHigherThan2000();
		}
		@Transactional
		 public List<Employee> findEmployeeNameStartsWithapt(){
			return empDao.findEmployeeNameStartsWithapt();
		}
}

