package com.microservice.course.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.course.dto.StudentDTO;

@FeignClient(name = "msvc-student", url="localhost:8098/api/student")
public interface StudentClient {
	
	@GetMapping("/search-by-course/{id}")
	List<StudentDTO> findByIdCourse(@PathVariable Long id);
}
