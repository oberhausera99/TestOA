package com.example.teszt;

import java.util.List;
import java.util.UUID;

import com.example.teszt.Student;

public interface StudentService {
	Student createStudent(Student student);

	Student updateStudent(Student student);

	List<Student> getAllStudent();

	Student getStudentById(UUID studentId);

	void deleteStudent(UUID id);
}