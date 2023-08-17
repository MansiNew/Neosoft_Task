package com.neo.repo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.neo.model.Student;



@Repository

public class StudentRepository  {
	
private RedisTemplate<String,Student> redisTemplate;
private HashOperations hashOperations;


	 
	 public StudentRepository(RedisTemplate<String, Student> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}

	
	 
	 final Logger logger = LoggerFactory.getLogger(StudentRepository.class);
	 
	 public void createStudent(Student student) {
			hashOperations.put("STUDENT", student.getRollNum(), student);
			
	        logger.info(String.format("Student with RollNum %s saved", student.getRollNum()));
		}
	 
	 public Student findStudent(Long rollNum) {
			return (Student) hashOperations.get("STUDENT", rollNum);
		}
	 
	 public Map<String,Student> getAllStudents(){
			return hashOperations.entries("STUDENT");
		}
	 
	 public Student updateStudent(Student student) {
			hashOperations.put("STUDENT", student.getRollNum(), student);
	        logger.info(String.format("student with rollNum %s updated", student.getRollNum()));
	        return student;
		}
	 
	 public void  deleteStudent(Long rollNum) {
			hashOperations.delete("STUDENT", rollNum);
	        logger.info(String.format("student with rollnum %s deleted", rollNum));
		}
	 
}
