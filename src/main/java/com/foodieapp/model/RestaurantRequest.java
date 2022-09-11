package com.foodieapp.model;

import java.util.List;

import lombok.Data;

@Data
public class RestaurantRequest {
	
	private int restId;
	private String restName;
	private String category;
	private String phone;
	private String location;
	private String status;
	private List<DishRequest> dishes;
	

}
