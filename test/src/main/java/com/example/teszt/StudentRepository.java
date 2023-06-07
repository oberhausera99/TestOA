package com.example.teszt;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teszt.Student;

public interface StudentRepository extends JpaRepository<Student, UUID> {
	
	
	
	

}