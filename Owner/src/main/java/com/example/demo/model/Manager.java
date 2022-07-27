package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Manager {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int code;
	private String employeeName;
	private String employeeAddress;
	private double salary;
	private int age;
	private String occupation;
	private String emailID;
	
}
