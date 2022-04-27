package models;

import java.util.UUID;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import enums.ContainerType;
import lombok.Data;

@Data
public class Container {

	
	private UUID id;
	
	
	
	@Size(min=2)
	@Pattern(regexp = "^(20|40)*$" , message = "container Size is 20 or 40")
	private int containerSize;
	
	private ContainerType containerType;
	
	@Size(min=5,max=20,message="lastName  should not blank")
	private String origin;
	
	@Size(min=5,max=20,message="lastName  should not blank")
	private String destination;
	
	@Size(min=1,max=100,message="lastName  should not blank")
	private int quantity;
	
	private String timeStamp;
}
