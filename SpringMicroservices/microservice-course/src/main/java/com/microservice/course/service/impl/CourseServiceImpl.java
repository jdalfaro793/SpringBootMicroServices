package com.microservice.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dao.CourseRepository;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.model.Course;
import com.microservice.course.service.CourseService;

/**
 * Implementation of the CourseService interface.
 * This class provides the business logic for course-related operations.
 */
@Service
public class CourseServiceImpl implements CourseService {

	/**
	 * Repository for accessing course data.
	 */
	@Autowired
	private CourseRepository courseRepository;
	
	/**
	 * Feign client for communicating with the student microservice.
	 */
	@Autowired
	private StudentClient studentClient;
	
	/**
	 * Retrieves all courses.
	 * @return A list of all courses.
	 */
	@Override
	public List<Course> findAll() {
		return (List<Course>) courseRepository.findAll();
	}

	/**
	 * Finds a course by its ID.
	 * @param id The ID of the course to find.
	 * @return The found course.
	 * @throws java.util.NoSuchElementException if the course with the given ID is not found.
	 */
	@Override
	public Course findById(Long id) {
		return courseRepository.findById(id).orElseThrow();
	}

	/**
	 * Saves a course.
	 * @param course The course to save.
	 */
	@Override
	public void save(Course course) {
		courseRepository.save(course);
	}

	/**
	 * Finds students associated with a course ID.
	 * This method retrieves the course details and then fetches the list of students for that course from the student microservice.
	 * @param idCourse The ID of the course.
	 * @return A StudentByCourseResponse object containing course details and a list of students.
	 */
	@Override
	public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
		//Consultar curso
		Course course = courseRepository.findById(idCourse).orElse(new Course());
		 
		List<StudentDTO> lisStudentsDTO = studentClient.findByIdCourse(idCourse);
		
		return StudentByCourseResponse.builder()
				.courseName(course.getName())
				.teacher(course.getTeacher())
				.students(lisStudentsDTO)		
				.build();
	}

}
