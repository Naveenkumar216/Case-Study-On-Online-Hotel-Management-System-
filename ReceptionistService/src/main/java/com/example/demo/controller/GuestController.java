package com.example.demo.controller;

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
import com.example.demo.model.Guest;
import com.example.demo.repository.GuestRepository;

@RestController
@RequestMapping("/guest")
@CrossOrigin("*")
public class GuestController {

	@Autowired
	private GuestRepository guestRepository;
	
	@GetMapping("/allguests")
	public List<Guest> allGuest(){
		return guestRepository.findAll();
	}
	
	@PostMapping("/addguest")
	public Guest addGuest(@RequestBody Guest guest) {
		return guestRepository.save(guest);	
	}
	
	@GetMapping("/guestbyid/{memberCode}")
	public ResponseEntity<Guest> getGuestByMemberCode(@PathVariable int memberCode)throws ResourceNotFoundException{
		Guest guest = guestRepository.findById(memberCode)
				.orElseThrow(()-> new ResourceNotFoundException("Guest not found for this memberCode :" + memberCode));
		return ResponseEntity.ok().body(guest);
	}
	
	@PutMapping("/updateguest/{memberCode}")
	public ResponseEntity<Guest> updateGuest( @RequestBody Guest guest, @PathVariable int memberCode ) throws ResourceNotFoundException {
	     Guest updateGuest = guestRepository.findById(memberCode)
	    		 .orElseThrow(()-> new ResourceNotFoundException("Guest not found for this memberCode :" + memberCode));
	     updateGuest.setPhoneNumber(guest.getPhoneNumber());
	     updateGuest.setCompany(guest.getCompany());
	     updateGuest.setName(guest.getName());
	     updateGuest.setEmail(guest.getEmail());
	     updateGuest.setGender(guest.getGender());
	     updateGuest.setAddress(guest.getAddress());
	     guestRepository.save(updateGuest);
	     return ResponseEntity.ok(updateGuest);
	}
	
	@DeleteMapping("/deleteguest/{memberCode}")
	public ResponseEntity<HttpStatus> deleteGuest(@PathVariable int memberCode) throws ResourceNotFoundException{	
		Guest guest= guestRepository.findById(memberCode)
				.orElseThrow(()-> new ResourceNotFoundException("Guest not found for this memberCode :" + memberCode));
		guestRepository.delete(guest);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
