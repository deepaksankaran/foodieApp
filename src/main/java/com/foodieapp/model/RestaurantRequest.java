package com.foodieapp.model;

import lombok.Data;

@Data
public class RestaurantRegRequest {
	
	private int restId;
	private String restName;
	private String userName;
	private String category;
	private String phone;
	private String location;
	

}
