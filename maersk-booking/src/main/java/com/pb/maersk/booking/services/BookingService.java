package com.pb.maersk.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import models.BookingAvailability;
import models.BookingResponse;


@Service
public class BookingService {

	@Autowired
	RestTemplate restTemplate ;
	
	public BookingResponse checkAvailability() {
		
		BookingAvailability bookingAvailability =  restTemplate.getForObject("https://maersk.com/api/bookings/checkAvailable",BookingAvailability.class);

		if(bookingAvailability.getAvailableSpace()>0)
		{
			return new BookingResponse(true);
		}
		return new BookingResponse(false);
	}

}
