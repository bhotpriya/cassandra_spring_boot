package models;

import java.util.UUID;

import enums.ContainerType;
import lombok.Data;

@Data
public class BookingResponse {
	
	public BookingResponse(boolean available) {
		super();
		this.available = available;
	}

	boolean available ;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	

}
