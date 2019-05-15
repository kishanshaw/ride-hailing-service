package com.xridesbookingdetails.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

	/*This is exception class that is thrown whenever record regarding a particular Booking_id is not found in database*/
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class RideNotFoundException extends Exception{
		private static final long serialVersionUID = 1L;

		public RideNotFoundException(String message){
	        super(message);
	    }
	}

