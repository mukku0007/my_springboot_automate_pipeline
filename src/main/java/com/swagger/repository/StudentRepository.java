package com.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swagger.Entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Transactional
	List<Student> findByCity(String city);

	@Transactional
	List<Student> findByAge(Integer age);
	
	@Transactional
	List<Student> findByName(String name);

}
