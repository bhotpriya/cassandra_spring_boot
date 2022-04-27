package com.pb.maersk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pb.maersk.data.Container;
import com.pb.maersk.services.ContainerService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/containers/")
public class ContainersController {
	
	@Autowired
	private ContainerService containerService;
	
	
	
	
	@PostMapping("addBooking")
	public  Mono<Container> create(@RequestBody Container request)
	{
		return containerService.createObject(request);
		
			
	}

}
