package com.example.hotelservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hotelservice.entity.Hotel;

public interface hotelService {

	Hotel createHotel(Hotel hotel);
	Hotel getHotelById(String id);
	List<Hotel> getListHotel();
}
