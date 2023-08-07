package com.neo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neo.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {
	@Query
	public Optional<Student> findStudentBystName(String stName);
	
	@Query(value="select s.stId,s.stName,s.marks,s.department,s.age from Student s where s.stId = ?stId",nativeQuery = true)
	public Student findStudentByStId(@Param(value = "stId") Long stId, Pageable pageable);
	
	@Query(value = "select count(*) from Student",nativeQuery = true)
	public int findTotalStudents();
 
	}
