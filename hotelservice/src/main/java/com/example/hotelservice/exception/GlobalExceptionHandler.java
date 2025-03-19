package com.example.hotelservice.exception;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourseNotFoundException.class)
	private ResponseEntity<Map<String,String>> resourceNotFoundException(ResourseNotFoundException ex){
		Map<String,String> map=new HashMap<String,String>();
		map.put("Message", ex.getMessage());
		map.put("Status", HttpStatus.BAD_REQUEST.toString());
		map.put("success", "fail");
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
	}
	
}
