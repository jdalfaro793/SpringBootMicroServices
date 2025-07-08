package com.microservice.course.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.course.model.Course;

/**
 * Repository interface for managing Course entities.
 * This interface extends CrudRepository to provide basic CRUD operations for Course objects.
 */
@Repository
public interface CourseRepository  extends CrudRepository<Course, Long>{

 	
}
