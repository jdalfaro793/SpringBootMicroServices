package com.microservice.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.student.dao.StudentRepository;
import com.microservice.student.model.Student;
import com.microservice.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public List<Student> findAll() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student findById(Long id) {
		return studentRepository.findById(id).orElseThrow();
	}

	@Override
	public void save(Student studend) {
		studentRepository.save(studend);
	}

	@Override
	public List<Student> findByIdCourse(Long idCourse) {
		return studentRepository.findAllByCourseId(idCourse);
	}

}
