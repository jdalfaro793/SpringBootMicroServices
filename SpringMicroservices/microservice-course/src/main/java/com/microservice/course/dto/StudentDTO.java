package com.microservice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for student information.
 * This class is used to transfer student data between layers or services.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
	
	/**
	 * The name of the student.
	 */
	private String name;
	
	/**
	 * The last name of the student.
	 */
	private String lastName;
	
	/**
	 * The email address of the student.
	 */
	private String email;
 
	/**
	 * The ID of the course the student is enrolled in.
	 */
	private Long courseId;
}
