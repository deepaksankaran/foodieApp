package com.foodieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodieapp.entity.Resturant;
import com.foodieapp.model.RestaurantRequest;
import com.foodieapp.model.ResturantResponse;
import com.foodieapp.service.ResturantService;
@RequestMapping("foodie/resturant")
@RestController
public class ResturantController {
	
	@Autowired
	ResturantService resturantService;
	
	//save
		@PostMapping("/save")
		public ResponseEntity<ResturantResponse> save(@RequestBody RestaurantRequest restaurantRegRequest){
			ResturantResponse resturantResponse=resturantService.save(restaurantRegRequest);		
			return new ResponseEntity<ResturantResponse>(resturantResponse,HttpStatus.OK);
		}
		//get resturant by resturant name
		@GetMapping("/get/{resturantName}")
		public ResponseEntity<Resturant> getResturant(@PathVariable String resturantName) {
			Resturant resturant=resturantService.getResturantData(resturantName);
			return new ResponseEntity<Resturant>(resturant,HttpStatus.OK);
		}
//		//get All resturants
		@GetMapping("/get/resturants")
		public List<Resturant> getResturants() {
			List<Resturant> resturants=resturantService.getAllResturants();
			return resturants;
		}
//		//update by resturant name
		@PutMapping("/update")
		public ResponseEntity<ResturantResponse>  update(@RequestBody RestaurantRequest restaurantRequest){
			ResturantResponse resturantResponse=resturantService.update(restaurantRequest);		
			return new ResponseEntity<ResturantResponse>(resturantResponse,HttpStatus.OK);
		}
//		//delete
		@DeleteMapping("/delete")
		public ResponseEntity<ResturantResponse> delete(@RequestBody RestaurantRequest restaurantRequest){
			ResturantResponse resturantResponse=resturantService.delete(restaurantRequest);		
			return new ResponseEntity<ResturantResponse>(resturantResponse,HttpStatus.OK);
		}

}
