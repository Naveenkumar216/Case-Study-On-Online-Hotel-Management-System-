package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberCode;
	private long phoneNumber;
	private String company;
	private String name;
	private String email;
	private String gender;
	private String address;

}
