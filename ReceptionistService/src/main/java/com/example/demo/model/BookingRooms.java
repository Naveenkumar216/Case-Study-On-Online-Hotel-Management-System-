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
public class BookingRooms {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codes;
	private int numberOfChildren;
	private int numberOfAdults;
	private String check_in_date;
	private String check_out_date;
	private String status;
	private int NumberOfNights;
	private int guestMemberCode;
	private int bookingRoomId;
	
	
}
