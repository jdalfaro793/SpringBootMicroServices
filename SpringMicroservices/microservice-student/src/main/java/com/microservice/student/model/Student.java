package com.microservice.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a student entity.
 * This class is mapped to the "students" table in the database.
 */
@Data
@Entity
@Builder
@Table(name="students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	/**
	 * The unique identifier for the student.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * The name of the student.
	 */
	private String name;
	
	/**
	 * The last name of the student.
	 */
	@Column(name = "last_name")
	private String lastName;
	
	/**
	 * The email address of the student.
	 */
	private String email;
	
	/**
	 * The ID of the course the student is enrolled in.
	 */
	@Column(name = "course_id")
	private Long courseId;
}
