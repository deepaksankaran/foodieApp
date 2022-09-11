package com.foodieapp.model;


import lombok.Data;
@Data
public class DishRequest {

	private String restName;
	
	private String dishName;
	
	private float dishPrice;
	
	private Integer NoOfOrders;
}
