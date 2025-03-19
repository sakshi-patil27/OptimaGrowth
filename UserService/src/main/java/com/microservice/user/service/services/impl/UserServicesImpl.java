package com.microservice.user.service.services.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.feign.HotelService;
import com.microservice.user.feign.RatingService;
import com.microservice.user.service.entity.Hotel;
import com.microservice.user.service.entity.Rating;
import com.microservice.user.service.entity.User;
import com.microservice.user.service.exception.ResourceNotFoundException;
import com.microservice.user.service.repo.UserRepository;
import com.microservice.user.service.services.UserService;

@Service
public class UserServicesImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RatingService ratingService;

	@Override
	public User userSave(User user) {
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return this.userRepo.save(user);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = this.userRepo.findAll();
		for (User user : users) {

			// This is used for the RestTemplate
//			String url="http://RATING-SERVICES/rating/getRatingsByUserId/users/"+user.getUserId();
//			Rating[] ratings = restTemplate.getForObject(url, Rating[].class);
//			List<Rating> list=Arrays.stream(ratings).toList();

			// when we are using feign client
			List<Rating> list = ratingService.getRating(user.getUserId());
			for (Rating rating : list) {

				// when we are using Rest template
//			    url="http://HOTEL-SERVICE/hotel/getHotel/"+rating.getHotelId();
//				ResponseEntity<Hotel> hotel = restTemplate.getForEntity(url, Hotel.class);

				// when we are using feign client
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
			}
			user.setRatings(list);
		}

		return users;
	}

	@Override
	public User getUser(String userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server" + userId));
		// This is used for the RestTemplate
//		String url = "http://RATING-SERVICES/rating/getRatingsByUserId/users/" + userId;
//		Rating[] ratings = restTemplate.getForObject(url, Rating[].class);
//		List<Rating> list = Arrays.stream(ratings).toList();

		// when we are using feign client
		List<Rating> list = ratingService.getRating(user.getUserId());

		for (Rating rating : list) {
//		    url="http://HOTEL-SERVICE/hotel/getHotel/"+rating.getHotelId();
//			ResponseEntity<Hotel> hotel = restTemplate.getForEntity(url, Hotel.class);
//			rating.setHotel(hotel.getBody());

			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
		}
		user.setRatings(list);
		return user;
	}

}
