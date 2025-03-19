package com.microservice.user.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private int ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	private Hotel hotel;

}