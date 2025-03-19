package com.example.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotelservice.entity.Hotel;

public interface hotelRepository extends JpaRepository<Hotel,String>{

}
