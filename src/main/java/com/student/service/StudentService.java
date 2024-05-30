package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Student;

public interface StudentService {

	public String createStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Optional<Student> getStudent(Integer studId);
	
	public String updateStudent(Integer studId, Student student);
	
	public String deleteStudent(Integer studId);
	
}
