package com.microservice.course.model;

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
 * Represents a course entity.
 * This class is mapped to the "courses" table in the database.
 */
@Data
@Entity
@Builder
@Table(name="courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	
	/**
	 * The unique identifier for the course.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * The name of the course.
	 */
	private String name;
	
	/**
	 * The teacher of the course.
	 */
	private String teacher;
	
}
