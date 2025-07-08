package com.microservice.student.service;

import java.util.List;

import com.microservice.student.model.Student;

/**
 * Service interface for managing students.
 * This interface defines methods for student-related operations.
 */
public interface StudentService {

	/**
	 * Retrieves all students.
	 * @return A list of all students.
	 */
	List<Student> findAll();
	
	/**
	 * Finds a student by their ID.
	 * @param id The ID of the student to find.
	 * @return The found student, or null if not found.
	 */
	Student findById(Long id);
	
	/**
	 * Saves a student.
	 * @param student The student to save.
	 */
	void save(Student student);
	
	/**
	 * Finds students by course ID.
	 * @param idCourse The ID of the course.
	 * @return A list of students enrolled in the specified course.
	 */
	List<Student> findByIdCourse(Long idCourse);
	
	
}
