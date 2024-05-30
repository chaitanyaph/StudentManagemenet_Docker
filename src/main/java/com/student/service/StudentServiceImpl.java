package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public String createStudent(Student student) {
		
		studentRepo.save(student);
		return "Student created Successfully";
	}

	@Override
	public List<Student> getAllStudents() {
		
		List<Student> findAll = studentRepo.findAll();
		return findAll;
	}

	@Override
	public Optional<Student> getStudent(Integer studId) {
	
		Optional<Student> findById = studentRepo.findById(studId);
		return findById;
	}

	@Override
	public String updateStudent(Integer studId, Student student) {
		
		Optional<Student> findById = studentRepo.findById(studId);
		
		if(findById.get() != null) {
			
			student.setEmail(student.getEmail());
			student.setAddress(student.getAddress());
			student.setPhoneNumber(student.getPhoneNumber());
			student.setDateOfBirth(student.getDateOfBirth());
			
			studentRepo.save(student);
			return "Student Data Updated Successfully";
		}
		
		return "Student Not Found with this Id";
	}

	@Override
	public String deleteStudent(Integer studId) {
		
		Optional<Student> findById = studentRepo.findById(studId);
		
		if(findById.get() != null) {
			
			studentRepo.deleteById(studId);
			return "Student Record Deleted Successfully";
		}
		return "Student record not found with this Id";
	}

}
