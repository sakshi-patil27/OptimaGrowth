package com.microservice.user.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.service.entity.Rating;

@FeignClient(name = "RATING-SERVICES")
public interface RatingService {
	@GetMapping("/rating/getRatingsByUserId/users/{userId}")
	List<Rating> getRating(@PathVariable String userId);

}