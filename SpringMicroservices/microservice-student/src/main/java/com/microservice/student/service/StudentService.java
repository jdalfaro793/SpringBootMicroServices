package com.microservice.student.service;

import java.util.List;

import com.microservice.student.model.Student;

public interface StudentService {

	List<Student> findAll();
	
	Student findById(Long id);
	
	void save(Student studend);
	
	List<Student> findByIdCourse(Long idCourse);
	
	
}
