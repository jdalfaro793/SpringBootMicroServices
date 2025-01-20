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

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentClient studentClient;
	
	@Override
	public List<Course> findAll() {
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public Course findById(Long id) {
		return courseRepository.findById(id).orElseThrow();
	}

	@Override
	public void save(Course studend) {
		courseRepository.save(studend);
	}

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
