 package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.BookingRooms;
import com.example.demo.model.Rooms;
import com.example.demo.service.BookingRoomsService;

@RestController
@RequestMapping("/bookingrooms")
public class BookingRoomsController {

	@Autowired
	BookingRoomsService bookingRoomsService;
	
	@PostMapping("/addbookingrooms")
	public BookingRooms addbookingrooms(@RequestBody BookingRooms bookingRooms) {
		return bookingRoomsService.addbookingrooms(bookingRooms);
	}
	
	@GetMapping("/allbookingrooms")
	public List<BookingRooms> allBookingRooms(){
		return bookingRoomsService.allBookingRooms();
	}
	
	@PostMapping("/updatebookingrooms/{codes}")
	public BookingRooms updateBookingRooms(@RequestBody BookingRooms bookingRooms,@PathVariable int codes) {
		return bookingRoomsService.updateBookingRooms(bookingRooms,codes);
		
	}
	
	
	@DeleteMapping("/deletebookingrooms/{codes}")
	public String deleteBookingRooms(@PathVariable int codes) {
		return bookingRoomsService.deleteBookingRooms(codes);
	}
	
}