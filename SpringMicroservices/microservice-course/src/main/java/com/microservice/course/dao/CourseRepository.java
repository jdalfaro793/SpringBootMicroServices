package com.microservice.course.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.course.model.Course;

@Repository
public interface CourseRepository  extends CrudRepository<Course, Long>{

 	
}
