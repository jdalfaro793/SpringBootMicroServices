package com.microservice.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.microservice.course.model.Course;
import com.microservice.course.service.CourseService;

/**
 * Controller for managing courses.
 * This class handles HTTP requests related to courses.
 */
@RestController
@RequestMapping("/api/course")
public class CourseController {

	/**
	 * Service for handling course-related operations.
	 */
	@Autowired
	CourseService courseservice;
	
	/**
	 * Saves a new course.
	 * This method handles POST requests to create a new course.
	 * @param cou The course object to be saved.
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCourse(@RequestBody Course cou) {
		courseservice.save(cou);
	}
	
	/**
	 * Retrieves all courses.
	 * This method handles GET requests to fetch all courses.
	 * @return A ResponseEntity containing a list of all courses and an HTTP status of OK.
	 */
	@GetMapping("/all")
	public ResponseEntity<?> findAllCourses(){
		return ResponseEntity.ok(courseservice.findAll());
	}
	
	
	/**
	 * Finds a course by its ID.
	 * This method handles GET requests to find a specific course by its ID.
	 * @param id The ID of the course to find.
	 * @return A ResponseEntity containing the found course and an HTTP status of OK.
	 */
	@GetMapping("/search/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(courseservice.findById(id));
	}
	
	/**
	 * Finds students associated with a course ID.
	 * This method handles GET requests to find students enrolled in a specific course.
	 * @param idCourse The ID of the course.
	 * @return A ResponseEntity containing the list of students for the given course and an HTTP status of OK.
	 */
	@GetMapping("/search-student/{idCourse}")
	public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){
		return ResponseEntity.ok(courseservice.findStudentsByIdCourse(idCourse));
	}
	
 
}
