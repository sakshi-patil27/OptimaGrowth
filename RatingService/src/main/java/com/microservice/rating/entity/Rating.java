package com.microservice.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int ratingId;
private String userId;
private String hotelId;
private int rating;
private String feedback;

}
