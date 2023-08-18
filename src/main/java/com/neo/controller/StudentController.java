package com.neo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Student;
import com.neo.repo.StudentRepository;


@RestController
public class StudentController {
	
@Autowired
	private StudentRepository studentRepo;

@PostMapping("/createStudent")
public void createStudent(@RequestBody Student student) {
	studentRepo.createStudent(student);
}
@GetMapping("/findStudent/{rollNum}")
public Student findStudent(@PathVariable Long rollNum) {
	return studentRepo.findStudent(rollNum);
}

@GetMapping("/findAllStudentsMap")
public Map<Long,Student> getAllStudents(){
	return  studentRepo.getAllStudents();
}

@PutMapping("/updateStudent")
public Student updateStudent(@RequestBody Student student) {
return studentRepo.updateStudent(student);
}

@DeleteMapping("/deleteStudent/{rollNum}")
public void  deleteStudent(@PathVariable Long rollNum) {
	studentRepo.deleteStudent(rollNum);
}


@GetMapping("/findStudentsKeySet")
public Set<Long> findStudentsKeysSet(){
	return studentRepo.findStudentsKeysSet();
}

@PostMapping("/findAllStudentsByKeyList")
public List<Student> getAllStudents(@RequestBody List<Long> keyList){
	return studentRepo.findAllStudentsByKeyList( keyList);
}

@GetMapping("/findAllStudentsByHKey")
public List<Student> findAllStudentsByHKey(){
	return studentRepo.findAllStudentsByHKey();	
}

@PostMapping("/saveStudentMap")
public void   saveStudentMap(@RequestBody Map<Long,Student> studentMap){
	studentRepo.saveStudentMap(studentMap);
}


@GetMapping("/sizeOfHash")
public Long sizeOfHash() {
	return studentRepo.sizeOfHash();
}

@PostMapping("/saveStudentIfKeyNotExist")
public boolean saveStudentIfKeyIsNotPresent(@RequestBody Student student) {
	return studentRepo.saveStudentIfKeyIsNotPresent(student);
}



}