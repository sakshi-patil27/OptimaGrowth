package com.microservice.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.rating.entity.Rating;
import com.microservice.rating.repository.Ratingrepo;

@Service
public class RatingService {

	@Autowired
	private Ratingrepo ratingrepo;
	
	
	public Rating createRating(Rating rating) {
		return ratingrepo.save(rating);
	}

	public Rating getRating(int ratingId) {
		return ratingrepo.findById(ratingId).get();
	}
	public List<Rating> getAllRating() {
		return ratingrepo.findAll();
	}
	public List<Rating> getByUserIdRating(String userId) {
		return ratingrepo.findAllByUserId(userId);
	}
	
	public List<Rating> getByHotelIdRating(String hotelId) {
		return ratingrepo.findAllByHotelId(hotelId);
	}
	
}

