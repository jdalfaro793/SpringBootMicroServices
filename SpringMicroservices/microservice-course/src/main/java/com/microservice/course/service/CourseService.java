package com.microservice.course.service;

import java.util.List;

import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.model.Course;

/**
 * Service interface for managing courses.
 * This interface defines methods for course-related operations.
 */
public interface CourseService {

	/**
	 * Retrieves all courses.
	 * @return A list of all courses.
	 */
	List<Course> findAll();
	
	/**
	 * Finds a course by its ID.
	 * @param id The ID of the course to find.
	 * @return The found course, or null if not found.
	 */
	Course findById(Long id);
	
	/**
	 * Saves a course.
	 * @param course The course to save.
	 */
	void save(Course course);
		
	/**
	 * Finds students associated with a course ID.
	 * @param idCourse The ID of the course.
	 * @return A StudentByCourseResponse object containing course details and a list of students.
	 */
	StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
