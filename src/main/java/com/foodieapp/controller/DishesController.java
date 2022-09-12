package com.foodieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodieapp.model.RestaurantRequest;
import com.foodieapp.model.ResturantResponse;
import com.foodieapp.service.ResturantService;

@RequestMapping("foodie/dishes")
@RestController
public class DishesController {
	@Autowired
	ResturantService resturantService;
	
	//save
		@PostMapping("/save")
		public ResponseEntity<ResturantResponse> save(@RequestBody RestaurantRequest restaurantRegRequest){
			ResturantResponse resturantResponse=resturantService.save(restaurantRegRequest);		
			return new ResponseEntity<ResturantResponse>(resturantResponse,HttpStatus.OK);
		}
		
		//delete
				@DeleteMapping("/delete")
				public ResponseEntity<ResturantResponse> deleteDishes(@RequestBody RestaurantRequest restaurantRequest){
					ResturantResponse resturantResponse=resturantService.deleteDishes(restaurantRequest);		
					return new ResponseEntity<ResturantResponse>(resturantResponse,HttpStatus.OK);
				}
}
