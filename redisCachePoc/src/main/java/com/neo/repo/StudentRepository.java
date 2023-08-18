package com.neo.repo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.neo.model.Student;



@Repository
public class StudentRepository  {
	
private RedisTemplate<String,Student> redisTemplate;
private HashOperations hashOperations;
final Logger logger = LoggerFactory.getLogger(StudentRepository.class);

 
	 public StudentRepository(RedisTemplate<String, Student> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}

	 
	 public void createStudent(Student student) {
			hashOperations.put("STUDENT", student.getRollNum(), student);
	        logger.info(String.format("Student with RollNum %s saved", student.getRollNum()));
		}
	 
	 public Student findStudent(Long rollNum) {
			return (Student) hashOperations.get("STUDENT", rollNum);
		}
	 
	 public Map<Long,Student> getAllStudents(){
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
	 
	 
	 public Set<Long> findStudentsKeysSet(){
		 return hashOperations.keys("STUDENT");
	 }
	 
		public List<Student> findAllStudentsByKeyList(List<Long> keyList) {
			List<Student> studentList = new ArrayList<>();
			for (int i = 0; i < keyList.size(); i++) {
				Long rollNum = keyList.get(i);
				Student students = (Student) hashOperations.get("STUDENT", rollNum);
				studentList.add(students);
			}
			return studentList;
		}
	 
		
	 public List<Student> findAllStudentsByHKey(){
		 return hashOperations.values("STUDENT");
	 }
	 
	 
	 public Long sizeOfHash() {
		return  hashOperations.size("STUDENT");
	 }
	 
	 
	 public void  saveStudentMap(Map<Long,Student> studentMap) {
		 hashOperations.putAll("STUDENT",studentMap);
	 }
	 
	 public boolean saveStudentIfKeyIsNotPresent(Student student) {
			return  hashOperations.putIfAbsent("STUDENT", student.getRollNum(), student);
		 }
	 
	
	
}
