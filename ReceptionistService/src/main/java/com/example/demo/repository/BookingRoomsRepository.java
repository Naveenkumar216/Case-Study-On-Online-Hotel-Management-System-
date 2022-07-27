package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookingRooms;

@Repository
public interface BookingRoomsRepository extends JpaRepository<BookingRooms, Integer> {

}
