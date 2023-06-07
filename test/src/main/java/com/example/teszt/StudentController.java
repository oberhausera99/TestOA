package com.example.teszt;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.teszt.*;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/profile")
	public ResponseEntity<List<Student>> getAllStudent(){
		return ResponseEntity.ok().body(studentService.getAllStudent());
	}
	
	@GetMapping("/profile/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable UUID id){
		return ResponseEntity.ok().body(studentService.getStudentById(id));
	}
	
	@PostMapping("/profile")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
		return ResponseEntity.ok().body(this.studentService.createStudent(student));
	}
	
	@PutMapping("/profile/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable UUID id, @RequestBody Student student){
		student.setId(id);
		return ResponseEntity.ok().body(this.studentService.updateStudent(student));
	}

	@DeleteMapping("/profile/{id}")
	public HttpStatus deleteStudent(@PathVariable UUID id){
		this.studentService.deleteStudent(id);
		return HttpStatus.OK;
	}
}