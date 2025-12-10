package com.swagger.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.Entity.Student;
import com.swagger.exception.EmptyInputException;
import com.swagger.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/student")
@RequiredArgsConstructor
@Tag(name = "Student Controller", description = "To Perform operations on Students")
public class StudentController {
	
	
	private final StudentService studentService;
	
	@Operation(summary = "POST operations on students to add new Student", description = "It is used to save student object in database")
	@PostMapping("/addStudent")
	public ResponseEntity<Object> addStudent(@RequestBody Student student) {
		
		if(student.getName().isEmpty() || student.getName().length() == 0) {
			throw new EmptyInputException("601", "Input fields are empty.");
		}
		
		studentService.saveStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body("Student added successfully");
	}
	
	@Operation(summary = "GET operations on student to retrieve all Students", description = "It is used to retrieve student object from database")
	@GetMapping("/getAllStudent")
	public ResponseEntity<Object> getAllStudent() {
		Optional<List<Student>> student = studentService.getAllStudent();
		if (student.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(student.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found");
		}
	}

	@Operation(summary = "GET operations on students by using student id", description = "It is used to retrieve student object from database using student id")
	@GetMapping("/getStudentById/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable Integer id) {
		Optional<Student> student = studentService.getStudentById(id);
		if (student.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(student.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student Not Found for Id:" + id);
		}
	}

		@Operation(summary = "Update operations on students by using student id", description = "It is used to Update student object from database using student id")
		@PutMapping("/updateStudentById/{id}")
		public ResponseEntity<Object> updateStduentById(@PathVariable Integer id, @RequestBody Student student) {
			Optional<Student> studentOptional = studentService.getStudentById(id);
			if (studentOptional.isPresent()) {
				student.setId(id);
				studentService.saveStudent(student);
				return ResponseEntity.status(HttpStatus.OK).body("Student Updated Successfully for Id: " + id);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("Updation Failed..! Student not found for Id " + id);
			}
		}
	 
		@Operation(summary = "Delete operations on students by using student id", description = "It is used to Delete student object from database using student id")
		@DeleteMapping("/deleteStudentById/{id}")
		public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
			try {
				boolean studentExist = studentService.existsById(id);
				if (!studentExist) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with Id " + id + " Not Found.");
				}
				studentService.deleteStudentById(id);
				return ResponseEntity.status(HttpStatus.OK).body("Student Deleted Successfully..! with Id: " + id);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete student with Id: " + id);
						
			}
		}
		

		@Operation(summary = "Delete operations on student to delete all Students", description = "It is used to Delete All Student object from database.")
		@DeleteMapping("/deleteAllStudent")
		public ResponseEntity<String> deleteAllStudents(){
			try {
				studentService.deleteAllStudents();
				return ResponseEntity.ok().body("All students have been deleted successfully.");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to Delete All Students.");
			}
		}
		
		@Operation(summary = "GET operations on students by using student city", description = "It is used to get a list of Students from the specified city.")
		@GetMapping("/getStudentByCity/{city}")
		public ResponseEntity<List<Student>> getStudentByCity(@PathVariable String city) {
		    List<Student> students = studentService.findByCity(city);
		    if (!students.isEmpty()) {
		        return ResponseEntity.status(HttpStatus.OK).body(students);
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
		    }
		}
		
		
		@Operation(summary = "GET operations on students by using student age", description = "It is used to get a list of Students from the specified age.")
		@GetMapping("/getStudentByAge/{age}")
		public ResponseEntity<List<Student>> getStudentByAge(@PathVariable Integer age) {
			List<Student> studentbyAge = studentService.findByAge(age);
			if(!studentbyAge.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(studentbyAge);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
			}
		}
		
		@Operation(summary = "GET operations on students by using student name", description = "It is used to get a list of Students from the specified name.")
		@GetMapping("/getStudentByname/{name}")
		public ResponseEntity<List<Student>> getStudentByName(@PathVariable String name) {
			List<Student> studentByName = studentService.findByName(name);
			if(!studentByName.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(studentByName); 
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
			}
		}
}
