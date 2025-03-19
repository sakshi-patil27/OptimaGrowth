package com.microservice.rating.controller;

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
import com.microservice.rating.entity.Rating;
import com.microservice.rating.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingservice;
	
	 @PostMapping(value = "/createRate", consumes = "application/json")
		public ResponseEntity<Rating> create(@RequestBody Rating rating) {
			Rating ratesave = ratingservice.createRating(rating);
			return ResponseEntity.status(HttpStatus.CREATED).body(ratesave);

		}
	 
	 @GetMapping("/getRatings/{ratingId}")
		public ResponseEntity<Rating> getbyid(@PathVariable int ratingId) {
			Rating getrate = ratingservice.getRating(ratingId);
			return ResponseEntity.status(HttpStatus.CREATED).body(getrate);
		}
	
	 @GetMapping("/getRatings")
		public ResponseEntity<List<Rating>> getAllRating(){
		 List<Rating> list=ratingservice.getAllRating();
		 return ResponseEntity.status(HttpStatus.CREATED).body(list);
	 }

	 @GetMapping("/getRatingsByUserId/users/{userId}")
	 public ResponseEntity<List<Rating>> getByUserIdRating(@PathVariable String userId){
		 List<Rating> list=ratingservice.getByUserIdRating(userId);
		 return ResponseEntity.status(HttpStatus.CREATED).body(list);
	 }
	 @GetMapping("/getRatingsByHotelId/hotels/{hotelId}")
	 public ResponseEntity<List<Rating>>  getByhotelIdRating(@PathVariable String hotelId){
		 List<Rating> list=ratingservice.getByHotelIdRating(hotelId);
		 return ResponseEntity.status(HttpStatus.CREATED).body(list);
	 }
	 
}
