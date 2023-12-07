package com.LearnREST.controller;

import java.util.List;

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

import com.LearnREST.model.Student;
import com.LearnREST.service.StudentService;

//@restcontroller has both @controller and @responsebody
@RestController
//prioviding base url for controller for mapping
@RequestMapping("/api/students")
public class StudentController {
	StudentService studentService;

	// using constructor based dependency injection
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// build and create student REST api
	// we responseentity because we can provide complete response details
	// @requestbody annotation used to convert jason object to java object
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
	}

	// build to get all students REST api
	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudent();
	}

	// build to get a student by id REST api
	/*
	 * @GetMapping(value="/{id}")
	 *  public Student getStudentById(@PathVariable Long id)
	 *  { 
	 *  return studentService.getStudent(id); 
	 *  }
	 */
	// http://localhost:8080/api/student/1....this 1 is dynamic so we have to this
	// in {}
	// below mapping endpoint name as "{id}"(variable)..it should be same in the
	// path variable argument("id")
	// but the methods argument name can be anything(ex stuId)
	
	@GetMapping(value = "{id}")	
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long stuId) {

		return new ResponseEntity<Student>(studentService.getStudent(stuId), HttpStatus.OK);
	}
	
    // build to update student  by id RESTapi
	
	//doubt--is necessary that java object fields name and jason object's name-value pair's,the name should be same
	
	@PutMapping(value="{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long stuId,@RequestBody Student student){
		 
		return new ResponseEntity<Student>(studentService.updateStudent(student, stuId), HttpStatus.OK); 
	}
	
	//build to delete student by id REST api
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studId){
		   Student student = studentService.deleteStudent(studId);
		return new ResponseEntity<String>(student.toString()+" is deleted", HttpStatus.OK);
	}
}
