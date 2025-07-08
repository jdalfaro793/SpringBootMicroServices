package com.microservice.course.http.response;

import java.util.List;

import com.microservice.course.dto.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response object containing course details and a list of students enrolled in the course.
 * This class is used to structure the response when fetching students by course.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentByCourseResponse {
	/**
	 * The name of the course.
	 */
	private String courseName;
	/**
	 * The teacher of the course.
	 */
	private String teacher;
	/**
	 * A list of students enrolled in the course.
	 */
	private List<StudentDTO> students;

}
