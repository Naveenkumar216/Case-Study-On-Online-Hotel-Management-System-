package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Rooms;
import com.example.demo.repository.RoomsRepository;

@RestController
@RequestMapping("/roomscontroller")
@CrossOrigin("*")
public class RoomsController {
	
	@Autowired
	private RoomsRepository roomsRepository;
	
	@GetMapping("/allrooms")
	public List<Rooms> allRooms(){
		return roomsRepository.findAll();
	}
	
	@GetMapping("/rooms/{code}")
	public ResponseEntity<Rooms> getRoomsByRoomId(@PathVariable int roomId) throws ResourceNotFoundException{
		Rooms rooms = roomsRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("rooms not found for this code :" + roomId));
		return ResponseEntity.ok().body(rooms);
	}
	
	@PostMapping("/addrooms")
	public Rooms addRooms(@RequestBody Rooms rooms) {
		return roomsRepository.save(rooms);
	}
	
	@PutMapping("/updaterooms/{roomId}")
	public ResponseEntity<Rooms> updateRooms(@RequestBody Rooms rooms,@PathVariable int roomId) throws ResourceNotFoundException {
		Rooms updateRooms = roomsRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("rooms not found for this code :" + roomId));
		updateRooms.setFloor(rooms.getFloor());
		updateRooms.setType(rooms.getType());
		updateRooms.setPrice(rooms.getPrice());
		updateRooms.setBookingStatus(rooms.getBookingStatus());
		roomsRepository.save(updateRooms);
		return ResponseEntity.ok(updateRooms);
	}
	
	@DeleteMapping("/deleterooms/{roomId}")
	public ResponseEntity<HttpStatus>  deleteRooms(@PathVariable int roomId) throws ResourceNotFoundException{
		Rooms rooms= roomsRepository.findById(roomId)
				.orElseThrow(()-> new ResourceNotFoundException("Rooms not found for this code :" +roomId));
		roomsRepository.delete(rooms);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
}