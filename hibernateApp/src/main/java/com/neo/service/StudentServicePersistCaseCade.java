package com.neo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dao.StudentDao;
import com.neo.model.Student;

@Service
public class StudentServicePersistCaseCade {
	@Autowired
	private StudentDao studentDao;
	@Transactional
	public void createStudent(Student student) {
		studentDao.createStudent(student);
	}
	@Transactional
	 public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}
}
