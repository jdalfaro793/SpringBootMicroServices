package com.microservice.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.student.dao.StudentRepository;
import com.microservice.student.model.Student;
import com.microservice.student.service.StudentService;

/**
 * Implementation of the StudentService interface.
 * This class provides the business logic for student-related operations.
 */
@Service
public class StudentServiceImpl implements StudentService {

	/**
	 * Repository for accessing student data.
	 */
	@Autowired
	private StudentRepository studentRepository;
	
	
	/**
	 * Retrieves all students.
	 * @return A list of all students.
	 */
	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}

	/**
	 * Finds a student by their ID.
	 * @param id The ID of the student to find.
	 * @return The found student.
	 * @throws java.util.NoSuchElementException if the student with the given ID is not found.
	 */
	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).orElseThrow();
	}

	/**
	 * Saves a student.
	 * @param student The student to save.
	 */
	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	/**
	 * Finds students by course ID.
	 * @param idCourse The ID of the course.
	 * @return A list of students enrolled in the specified course.
	 */
	@Override
	public List<Student> findByIdCourse(Long idCourse) {
		return studentRepository.findAllByCourseId(idCourse);
	}

}
