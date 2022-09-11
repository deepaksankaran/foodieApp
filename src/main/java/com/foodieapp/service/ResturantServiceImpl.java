package com.foodieapp.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodieapp.entity.Dishes;
import com.foodieapp.entity.Resturant;
import com.foodieapp.model.DishRequest;
import com.foodieapp.model.RestaurantRequest;
import com.foodieapp.model.ResturantResponse;
import com.foodieapp.repository.DishesRepository;
import com.foodieapp.repository.ResturantRepository;

@Service
@Transactional
public class ResturantServiceImpl implements ResturantService {

	@Autowired
	ResturantRepository resturantRepository;

	@Autowired
	DishesRepository dishesRepository;

	public static final String BAR = "Bar";
	public static final String CAFE = "Cafe";
	public static final String CLOUD_KITCHEN = "Cloud Kitchen";
	public static final String TAKE_AWAY = "Take Away";
	public static final String STATUS_APPROVED = "Approved";
	public static final String STATUS_NOT_APPROVED = "Not Approved";

	@Override
	@Transactional
	public ResturantResponse save(RestaurantRequest restaurantRegRequest) {
		ResturantResponse resturantResponse = new ResturantResponse();
		Resturant resturantData = resturantRepository.findByRestName(restaurantRegRequest.getRestName());
		if (resturantData == null) {
			Resturant resturant = new Resturant();
			resturant.setRestName(restaurantRegRequest.getRestName());
			resturant.setLocation(restaurantRegRequest.getLocation());
			resturant.setPhone(restaurantRegRequest.getPhone());
			resturant.setStatus(STATUS_NOT_APPROVED);
			if (restaurantRegRequest.getCategory().equalsIgnoreCase(BAR)
					|| restaurantRegRequest.getCategory().equalsIgnoreCase(CAFE)
					|| restaurantRegRequest.getCategory().equalsIgnoreCase(CLOUD_KITCHEN)
					|| restaurantRegRequest.getCategory().equalsIgnoreCase(TAKE_AWAY)) {

				resturant.setCategory(restaurantRegRequest.getCategory());
			} else {
				resturant.setCategory("Other");
			}
			List<DishRequest> dishRequest = restaurantRegRequest.getDishes();

			List<Dishes> dishesList;
			if (dishRequest != null) {
				dishesList = new ArrayList<>();
				dishRequest.forEach(dishObj -> {
					Dishes dishes = new Dishes();
					dishes.setDishName(dishObj.getDishName());
					dishes.setDishPrice(dishObj.getDishPrice());
					dishes.setNoOfOrders(dishObj.getNoOfOrders());
					dishes.setRestName(restaurantRegRequest.getRestName());
					dishes.setCreatedDate(new Timestamp(System.currentTimeMillis()));
					// dishes.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
					// dishesRepository.save(dishes);
					dishesList.add(dishes);
					// dishesRepository.saveAll(dishesList);
				});
				resturant.setDishes(dishesList);
			}

			resturant.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			resturantRepository.save(resturant);
			resturantResponse.setMessage("Resturant information succssfully saved");
		} else {
			resturantResponse.setMessage("Resturant information already exist");

		}
		return resturantResponse;
	}

	@Override
	public Resturant getResturantData(String resturantName) {
		Resturant resturant = null;
		resturant = resturantRepository.findByRestName(resturantName);
		return resturant;
	}

	@Override
	public List<Resturant> getAllResturants() {
		return resturantRepository.findAll();
	}

	@Override
	public ResturantResponse update(RestaurantRequest restaurantRequest) {
		ResturantResponse resturantResponse = new ResturantResponse();

		Resturant resturant = resturantRepository.findByRestName(restaurantRequest.getRestName());
		if (resturant != null) {
			// resturant.setRestName(restaurantRequest.getRestName());
			resturant.setLocation(restaurantRequest.getLocation());
			resturant.setPhone(restaurantRequest.getPhone());
			if (restaurantRequest.getCategory().equalsIgnoreCase(BAR)
					|| restaurantRequest.getCategory().equalsIgnoreCase(CAFE)
					|| restaurantRequest.getCategory().equalsIgnoreCase(CLOUD_KITCHEN)
					|| restaurantRequest.getCategory().equalsIgnoreCase(TAKE_AWAY)) {

				resturant.setCategory(restaurantRequest.getCategory());
			} else {
				resturant.setCategory("Other");
			}
			List<DishRequest> dishRequest = restaurantRequest.getDishes();
			if (dishRequest == null || dishRequest.size() == 0) {
				System.out.println("Empty Dishes list");
			} else {

				dishRequest.forEach(dishObj -> {
					Dishes disheData = dishesRepository.findByRestNameAndDishName(resturant.getRestName(),
							dishObj.getDishName());
					if (disheData != null) {
						disheData.setDishName(dishObj.getDishName());
						disheData.setDishPrice(dishObj.getDishPrice());
						disheData.setNoOfOrders(dishObj.getNoOfOrders());
						disheData.setRestName(restaurantRequest.getRestName());
						// disheData.setCreatedDate(new Timestamp(System.currentTimeMillis()));
						disheData.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
						dishesRepository.save(disheData);
					} else {
						Dishes dishes = new Dishes();
						dishes.setDishName(dishObj.getDishName());
						dishes.setDishPrice(dishObj.getDishPrice());
						dishes.setNoOfOrders(dishObj.getNoOfOrders());
						dishes.setRestName(restaurantRequest.getRestName());
						// dishes.setCreatedDate(new Timestamp(System.currentTimeMillis()));
						dishes.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
						dishesRepository.save(dishes);
					}
				});
			}
			resturant.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
			resturantRepository.save(resturant);
			resturantResponse.setMessage("Resturant information succssfully updated");
		} else {
			resturantResponse.setMessage("Resturant information doesn't exist");
		}
		return resturantResponse;
	}

	@Override
	public ResturantResponse delete(RestaurantRequest restaurantRequest) {
		ResturantResponse resturantResponse = new ResturantResponse();
		Resturant resturant = resturantRepository.findByRestName(restaurantRequest.getRestName());
		if (resturant == null) {
			resturantResponse.setMessage("Resturant information doesn't exist");
		} else {
			resturantRepository.delete(resturant);
			resturantResponse.setMessage("Resturant information is successfully deleted");
		}
		return resturantResponse;
	}

	@Override
	public ResturantResponse updateStatus(RestaurantRequest restaurantRequest) {
		Boolean isApproved = (restaurantRequest.getStatus()).equalsIgnoreCase(STATUS_APPROVED);
		Boolean notApproved = (restaurantRequest.getStatus()).equalsIgnoreCase(STATUS_NOT_APPROVED);
		ResturantResponse resturantResponse = new ResturantResponse();
		Resturant resturant = resturantRepository.findByRestName(restaurantRequest.getRestName());

		if (resturant != null) {
			if (isApproved == true || notApproved == true) {
				resturant.setStatus(restaurantRequest.getStatus());
			}
			resturant.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
			resturantRepository.save(resturant);
			resturantResponse.setMessage("Resturant information succssfully updated by Admin");
		} else {
			resturantResponse.setMessage("Resturant information doesn't exist");
		}
		return resturantResponse;
	}

}
