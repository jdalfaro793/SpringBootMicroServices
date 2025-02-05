package com.microservice.student.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.student.model.Student;

@Repository
public interface StudentRepository  extends CrudRepository<Student, Long>{

	List<Student> findAllByCourseId(Long idCourse);
	
}
