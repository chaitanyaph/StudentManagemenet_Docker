package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String getMessage() {
		
		return "Welcome To Ashok IT";
	}
	
	@PostMapping("students/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student){
		
		String createStudent = studentService.createStudent(student);
		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		List<Student> allStudents = studentService.getAllStudents();
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}
	
	
	@GetMapping("/students/{studId}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable Integer studId){
		
		Optional<Student> student = studentService.getStudent(studId);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@PutMapping("/students/{studId}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer studId,@RequestBody Student student){
		
		String updateStudent = studentService.updateStudent(studId, student);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/students/{studId}")
	public ResponseEntity<String> deletestudent(@PathVariable Integer studId){
		
		String deleteStudent = studentService.deleteStudent(studId);
		return new ResponseEntity<>(deleteStudent, HttpStatus.OK);
	}
}
