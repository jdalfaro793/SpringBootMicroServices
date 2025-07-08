package com.microservice.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.dto.StudentDTO;

/**
 * Feign client interface for interacting with the student microservice.
 * This interface defines methods to communicate with the student microservice endpoints.
 */
@FeignClient(name = "microservice-student", url = "http://microservice-student:8090/api/student")
public interface StudentClient {
	
	/**
	 * Finds students by course ID.
	 * This method sends a GET request to the student microservice to retrieve a list of students associated with a given course ID.
	 * @param id The ID of the course.
	 * @return A list of StudentDTO objects representing the students found.
	 */
	@GetMapping("/search-by-course/{id}")
	List<StudentDTO> findByIdCourse(@PathVariable Long id);
}
