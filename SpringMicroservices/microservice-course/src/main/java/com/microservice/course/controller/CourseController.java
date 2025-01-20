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

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	CourseService courseservice;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCourse(@RequestBody Course cou) {
		courseservice.save(cou);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllCourses(){
		return ResponseEntity.ok(courseservice.findAll());
	}
	
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok(courseservice.findById(id));
	}
	
	@GetMapping("/search-student/{idCourse}")
	public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse){
		return ResponseEntity.ok(courseservice.findStudentsByIdCourse(idCourse));
	}
	
 
}
