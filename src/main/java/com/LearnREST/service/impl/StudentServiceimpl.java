package com.LearnREST.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.LearnREST.exception.ResourceNotFoundException;
import com.LearnREST.model.Student;
import com.LearnREST.repository.StudentRepository;
import com.LearnREST.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {

	private StudentRepository studentRepository;

	// no need @autowired this constructor because if spring bean has one
	// constructor
	// then springboot will configure automatically
	// we are use constructor based dependency injection
	public StudentServiceimpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		/*
		 * Optional<Student> student = studentRepository.findById(id);
		 * if(student.isPresent()) 
		 * return student.get();
		 *  else throw new ResourceNotFoundException("Student", "id", id);
		 */
		// lamda expression
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		Student existinStudent = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		existinStudent.setDepartment(student.getDepartment());
		existinStudent.setFirstname(student.getFirstname());
		existinStudent.setLastname(student.getLastname());
		studentRepository.save(existinStudent);
		return existinStudent;
	}

	@Override
	public Student deleteStudent(Long id) {
		Student student=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student", "id", id));
		studentRepository.deleteById(id);
		return student;
	}

}