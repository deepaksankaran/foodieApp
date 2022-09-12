package com.foodieapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodieapp.entity.Resturant;
import com.foodieapp.model.RestaurantRequest;
import com.foodieapp.model.ResturantResponse;

@Service
public interface ResturantService {

	ResturantResponse save(RestaurantRequest restaurantRegRequest);

	Resturant getResturantData(String resturantName);

	List<Resturant> getAllResturants();

	ResturantResponse update(RestaurantRequest restaurantRequest);

	ResturantResponse delete(RestaurantRequest restaurantRequest);

	ResturantResponse updateStatus(RestaurantRequest restaurantRequest);

	ResturantResponse deleteDishes(RestaurantRequest restaurantRequest);

}
