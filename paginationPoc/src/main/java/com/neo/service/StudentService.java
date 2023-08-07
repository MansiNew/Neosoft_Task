package com.neo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.neo.exception.PageSizeIsNotValidException;
import com.neo.exception.StudentAlraedyExistException;
import com.neo.exception.StudentNotFoundException;
import com.neo.model.Student;
import com.neo.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private EntityManager entityManager;
	
public Student createStudent(Student student) {
	if(studentRepo.findById(student.getStId()).isPresent()) {
		throw new StudentAlraedyExistException("student is already exist so you cannot create student for this id");
	}
	return studentRepo.save(student);
}


	public Optional<Student> findStudentById(Long stId) throws StudentNotFoundException{
		if(!studentRepo.findById(stId).isPresent()) {
			throw new StudentNotFoundException("student not found for this student id please enter valid student id");	
		}
		return studentRepo.findById(stId);
	}
	
	
	public Optional<Student> findStudentBystName(String stName) throws StudentNotFoundException{
		if(!studentRepo.findStudentBystName(stName).isPresent()) {
			throw new StudentNotFoundException("student not found for this student name please enter valid student name");	
		}
		return studentRepo.findStudentBystName(stName);
	}
	
	public Page<Student> findStudentsByPage(int pageNumber,int pageSize) throws PageSizeIsNotValidException{
		int totalStudents = studentRepo.findTotalStudents();
		if(pageSize>totalStudents) {
			throw new PageSizeIsNotValidException("page size is greater than total number of elements so please enter valid page size to get  response");
		}
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		return studentRepo.findAll(pageRequest);
	}
	
	public List<Student> findStudentByPageRange(int first, int max) {
		String sql = "from Student";
		Query query = entityManager.createQuery(sql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		List<Student> stList = query.getResultList();
		return stList;
	}
	
	
	public Page<Student> sortStudentsByNameDecendingOrder(int pageNumber,int pageSize,String stName){
		PageRequest page = PageRequest.of(pageNumber, pageSize, Sort.by(stName).descending());
		Page<Student> studentPage= studentRepo.findAll(page);
		return studentPage;
	}
}
