package com.example.hotelservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.service.hotelService;


@RestController
@RequestMapping("/hotel")
public class hotelController {
	@Autowired
    private hotelService hotelservice;
	
	@PostMapping(value = "/createHotel", consumes = "application/json")
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
		Hotel usersave = hotelservice.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(usersave);

	}
	
	@GetMapping("/getHotel/{hotelId}")
	public ResponseEntity<Hotel> getbyid(@PathVariable String hotelId) {
		Hotel userget = hotelservice.getHotelById(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(userget);
	}
	
	@GetMapping("/getHotels")
	public ResponseEntity<List<Hotel>> getall() {
		List<Hotel> list = hotelservice.getListHotel();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	
}
