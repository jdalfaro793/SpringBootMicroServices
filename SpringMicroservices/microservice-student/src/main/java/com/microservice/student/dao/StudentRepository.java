package com.microservice.student.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.student.model.Student;

/**
 * Repository interface for managing Student entities.
 * This interface extends CrudRepository to provide basic CRUD operations for Student objects
 * and includes a custom method to find all students by course ID.
 */
@Repository
public interface StudentRepository  extends CrudRepository<Student, Long>{

	/**
	 * Finds all students associated with a given course ID.
	 * @param idCourse The ID of the course.
	 * @return A list of students enrolled in the specified course.
	 */
	List<Student> findAllByCourseId(Long idCourse);
	
}
