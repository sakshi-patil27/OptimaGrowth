package com.example.hotelservice.exception;

public class ResourseNotFoundException extends RuntimeException{
	public ResourseNotFoundException(){
		super("This Resourse are not found in the table");
	}
	public ResourseNotFoundException(String msg){
		super(msg);
	}
}
