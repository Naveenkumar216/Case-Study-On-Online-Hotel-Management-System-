package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BookingRooms;
import com.example.demo.repository.BookingRoomsRepository;

@Service
public class BookingRoomsService {

	@Autowired
	BookingRoomsRepository bookingRoomsRepository;

	public BookingRooms addbookingrooms(BookingRooms bookingRooms) {
		
		return bookingRoomsRepository.save(bookingRooms);
	}

	public List<BookingRooms> allBookingRooms() {
	
		return bookingRoomsRepository.findAll();
	}

	public String deleteBookingRooms(int codes) {
	     bookingRoomsRepository.deleteById(codes);
		return "deletebookingrooms is successfully" ;
	}

	public BookingRooms updateBookingRooms(BookingRooms bookingRooms, int codes) {
		return bookingRoomsRepository.save(bookingRooms);
	}
}
