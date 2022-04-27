package com.pb.maersk.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.maersk.data.Container;
import com.pb.maersk.repositories.ContainerRepository;

import reactor.core.publisher.Mono;

@Service
public class ContainerService {

	@Autowired ContainerRepository repository;
	
	
	
	public Mono<Container> createObject(Container object) {
		
		return repository.save(object);
		
	}


}
