package com.example.teszt;


import java.util.UUID;

//import jakarta.persistence.*;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name = "nev")
	private String nev;
	
	@Column(name = "email")
	private String email;

	/*public Student(UUID id, String nev, String email) {
		super();
		this.id = id;
		this.nev = nev;
		this.email = email;
	} */

	public UUID getId() {
		return id;
	}

	public String getNev() {
		return nev;
	}

	public String getEmail() {
		return email;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}