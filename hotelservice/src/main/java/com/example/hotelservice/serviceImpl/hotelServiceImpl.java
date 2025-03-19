package com.example.hotelservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelservice.entity.Hotel;
import com.example.hotelservice.exception.ResourseNotFoundException;
import com.example.hotelservice.repository.hotelRepository;
import com.example.hotelservice.service.hotelService;

import lombok.Setter;

@Service
public class hotelServiceImpl implements hotelService{
          
	@Autowired
	private hotelRepository hotelrepository;
	@Override
	public Hotel createHotel(Hotel hotel) {
		String id=UUID.randomUUID().toString();
		hotel.setId(id);
		Hotel hotel1=hotelrepository.save(hotel);
		return hotel1;
	}

	@Override
	public Hotel getHotelById(String id) {
		Hotel hotel=hotelrepository.findById(id).orElseThrow(()-> new ResourseNotFoundException(id+"This id is not present in the table"));
		return hotel;
	}

	@Override
	public List<Hotel> getListHotel() {
		return hotelrepository.findAll();
	}

}
