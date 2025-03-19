package com.microservice.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.user.service.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/hotel/getHotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);

}
