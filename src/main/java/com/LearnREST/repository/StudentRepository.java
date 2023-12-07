package com.LearnREST.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.LearnREST.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}