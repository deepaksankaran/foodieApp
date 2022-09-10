package com.foodieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodieapp.model.RestaurantRequest;
import com.foodieapp.model.ResturantResponse;
import com.foodieapp.service.ResturantService;

@RequestMapping("foodie/admin")
@RestController
public class AdminController {
	
	@Autowired
	ResturantService resturantService;
	
	@PutMapping("/update-status")
	public ResponseEntity<ResturantResponse>  update(@RequestBody RestaurantRequest restaurantRequest){
		ResturantResponse resturantResponse=resturantService.updateStatus(restaurantRequest);		
		return new ResponseEntity<ResturantResponse>(resturantResponse,HttpStatus.OK);
	}
}
