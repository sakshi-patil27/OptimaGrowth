package com.microservice.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.rating.entity.Rating;

public interface Ratingrepo  extends JpaRepository<Rating, Integer>{
   public List<Rating> findAllByUserId(String userId);
   public List<Rating> findAllByHotelId(String hotelId);
	
}
