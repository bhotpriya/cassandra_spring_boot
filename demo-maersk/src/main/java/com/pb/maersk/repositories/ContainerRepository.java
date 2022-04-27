package com.pb.maersk.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.pb.maersk.data.Container;


@Repository
public interface ContainerRepository extends ReactiveCassandraRepository<Container, UUID> {
	
	
	

}
