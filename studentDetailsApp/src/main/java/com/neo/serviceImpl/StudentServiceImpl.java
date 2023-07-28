package com.neo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neo.model.Student;
import com.neo.repo.StudentRepo;
import com.neo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);

	}

	@Override
	public String deleteStudent(Long rollNum) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(rollNum);
		return "student deleted successfully for " + rollNum + "   rollNumber";
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> findByRollNum(long rollNum) {
		// TODO Auto-generated method stub
		return studentRepo.findById(rollNum);
	}

	@Override
	public Student updateStudent(Student request) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepo.findById(request.getRollNum());

		Student updatedStudent = new Student();
		updatedStudent = student.get();
		updatedStudent.setRollNum(request.getRollNum());
		updatedStudent.setName(request.getName());
		updatedStudent.setMarks(request.getMarks());
		updatedStudent.setDepartment(request.getDepartment());
		updatedStudent.setAddress(request.getAddress());
		Student createdStudent = studentRepo.save(updatedStudent);
		return createdStudent;
	}

}
