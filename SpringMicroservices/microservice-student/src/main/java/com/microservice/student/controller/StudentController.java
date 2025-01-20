package com.microservice.student.controller;

 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.microservice.student.model.Student;
import com.microservice.student.service.StudentService;
 

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentservice;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveStudent(@RequestBody Student stu) {
		studentservice.save(stu);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllStudents(){
		return ResponseEntity.ok(studentservice.findAll());
	}
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(studentservice.findById(id));
	}
	
	@GetMapping("/search-by-course/{id}")
	public ResponseEntity<?> findByIdCourse(@PathVariable Long id){
		return ResponseEntity.ok(studentservice.findByIdCourse(id));
	}
	
}
