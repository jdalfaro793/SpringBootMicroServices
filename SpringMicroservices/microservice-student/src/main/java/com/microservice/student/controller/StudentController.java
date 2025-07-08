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
 
/**
 * Controller for managing students.
 * This class handles HTTP requests related to students.
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

	/**
	 * Service for handling student-related operations.
	 */
	@Autowired
	StudentService studentservice;
	
	/**
	 * Saves a new student.
	 * This method handles POST requests to create a new student.
	 * @param stu The student object to be saved.
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveStudent(@RequestBody Student stu) {
		studentservice.save(stu);
	}
	
	/**
	 * Retrieves all students.
	 * This method handles GET requests to fetch all students.
	 * @return A ResponseEntity containing a list of all students and an HTTP status of OK.
	 */
	@GetMapping("/all")
	public ResponseEntity<?> findAllStudents(){
		return ResponseEntity.ok(studentservice.findAll());
	}
	
	
	/**
	 * Finds a student by their ID.
	 * This method handles GET requests to find a specific student by their ID.
	 * @param id The ID of the student to find.
	 * @return A ResponseEntity containing the found student and an HTTP status of OK.
	 */
	@GetMapping("/search/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(studentservice.findById(id));
	}
	
	/**
	 * Finds students by course ID.
	 * This method handles GET requests to find students enrolled in a specific course.
	 * @param id The ID of the course.
	 * @return A ResponseEntity containing a list of students for the given course and an HTTP status of OK.
	 */
	@GetMapping("/search-by-course/{id}")
	public ResponseEntity<?> findByIdCourse(@PathVariable Long id){
		return ResponseEntity.ok(studentservice.findByIdCourse(id));
	}
	
}
