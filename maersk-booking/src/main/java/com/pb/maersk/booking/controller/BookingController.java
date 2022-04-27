package com.pb.maersk.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.pb.maersk.booking.services.BookingService;

import models.BookingResponse;
import models.Container;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bookings/")
public class BookingController {
	
	@Autowired BookingService bookingService;
	
	
	@GetMapping("checkAvailable")
	public BookingResponse  checkAvailable()
	{
		
		return bookingService.checkAvailability();
		
	}
	
	
	@PostMapping("addNewBooking")
	public Mono<Container> create(@RequestBody Container request)
	{
		WebClient webClient = WebClient.create("http://localhost:3000");

		Mono<Container> createdrequest = webClient.post()
				.uri("/api/containers/addBooking")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(request), Container.class)
				.retrieve()
				.bodyToMono(Container.class);
		
		return createdrequest;
	}
	
	

}
