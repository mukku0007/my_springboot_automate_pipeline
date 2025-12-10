package com.swagger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.swagger.Entity.Student;
import com.swagger.repository.StudentRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	
	private final StudentRepository studentRepository;
	
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}
	
	public Optional <List<Student>> getAllStudent() {
		return Optional.of(studentRepository.findAll());
	}
	
	public Optional<Student> getStudentById(Integer id){
		return studentRepository.findById(id);
		
	}
	
	public boolean existsById(Integer id) {
	    return studentRepository.existsById(id);
	}
	
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
	}
	
	public void deleteAllStudents() {
		studentRepository.deleteAll();
	}
	
	public List<Student> findByCity(String city) {
	    return studentRepository.findByCity(city);
	}
	
	public List<Student> findByAge(Integer age) {
		return studentRepository.findByAge(age);
	}
	
	public List<Student> findByName(String name) {
		return studentRepository.findByName(name);
	}
}
