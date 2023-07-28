package com.neo.service;

import java.util.List;
import java.util.Optional;


import com.neo.model.Student;

public interface StudentService {
public Student createStudent(Student student);
public String deleteStudent(Long rollNum);
public List<Student> findAllStudents();
public Optional<Student> findByRollNum(long rollNum);
Student updateStudent(Student request) ;
}
