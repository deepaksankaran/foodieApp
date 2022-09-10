package com.foodieapp.model;

import lombok.Data;

@Data
public class UserRegRequest {
	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String dob;
	private String phone;
	private String location;
	

}
