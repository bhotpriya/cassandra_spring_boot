package com.pb.maersk.data;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import enums.ContainerType;
import lombok.Data;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
public class Container implements Serializable {

	@PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
	private UUID bookingRef;
	
	
	
	@Column("container_size")
	@Size(min=2)
	@Pattern(regexp = "^(20|40)*$" , message = "container Size is 20 or 40")
	private int containerSize;
	
	@Column("container_type")
	private ContainerType containerType;
	
	@Column("origin")
	@Size(min=5,max=20,message="lastName  should not blank")
	private String origin;
	
	@Column("destination")
	@Size(min=5,max=20,message="lastName  should not blank")
	private String destination;
	
	@Column("quantity")
	@Size(min=1,max=100,message="lastName  should not blank")
	private int quantity;
	
	@Column("time_stamp")
	private String timeStamp;
}
