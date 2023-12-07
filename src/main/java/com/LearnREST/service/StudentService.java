package com.LearnREST.service;

import java.util.List;

import com.LearnREST.model.Student;

public interface StudentService {
	
      Student saveStudent(Student student);
      List<Student> getAllStudent();
      Student getStudent(Long id);
      Student updateStudent(Student student,Long id);
      Student deleteStudent(Long id);
}
