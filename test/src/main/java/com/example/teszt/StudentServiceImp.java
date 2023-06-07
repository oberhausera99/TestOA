package com.example.teszt;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.teszt.*;

@Service
@Transactional
public class StudentServiceImp implements StudentService{

	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student createStudent(Student student) {
		int freq1 = 0;
		int freq2 = 0;
		
		String email_address = student.getEmail();
		char[] c = email_address.toCharArray();
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] == '.') {
				freq1++;
			}
			if(c[i] == '@') {
				freq2++;
			}
		}
		
		if(freq1 != 1 || freq2 != 1) {
			throw new InvalidEmailException("Érvénytelen email cím!");
		} else {
		
		return studentRepository.save(student);
		}
	}

	@Override
	public Student updateStudent(Student student) {
		int freq1 = 0;
		int freq2 = 0;
		
		String email_address = student.getEmail();
		char[] c = email_address.toCharArray();
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] == '.') {
				freq1++;
			}
			if(c[i] == '@') {
				freq2++;
			}
		}
		
		if(freq1 != 1 || freq2 != 1) {
			throw new InvalidEmailException("Érvénytelen email cím!");
		} else {
		
		
		Optional<Student> studentDb = this.studentRepository.findById(student.getId());
		
		
			Student studentUpdate = studentDb.get();
			studentUpdate.setId(student.getId());
			studentUpdate.setNev(student.getNev());
			studentUpdate.setEmail(student.getEmail());
			studentRepository.save(studentUpdate);
			return studentUpdate;
			
	}
	}

	@Override
	public List<Student> getAllStudent() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(UUID studentId) {
		
		Optional<Student> studentDb = this.studentRepository.findById(studentId);
		
		
			return studentDb.get();
		
	}

	@Override
	public void deleteStudent(UUID studentId) {
		Optional<Student> studentDb = this.studentRepository.findById(studentId);
		
		
			this.studentRepository.delete(studentDb.get());
		
		
	}

}