package com.foodieapp.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodieapp.entity.Resturant;
import com.foodieapp.model.RestaurantRequest;
import com.foodieapp.model.ResturantResponse;
import com.foodieapp.repository.ResturantRepository;

@Service
public class ResturantServiceImpl implements ResturantService {

	@Autowired
	ResturantRepository resturantRepository;

	public static final String BAR = "Bar";
	public static final String CAFE = "Café";
	public static final String CLOUD_KITCHEN = "Cloud Kitchen";
	public static final String TAKE_AWAY = "Take Away";
	public static final String STATUS_APPROVED = "Approved";
	public static final String STATUS_NOT_APPROVED = "Not Approved";

	@Override
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
				resturant.setCategory("OTHER");
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
			resturant.setCategory(restaurantRequest.getCategory());
			resturant.setLocation(restaurantRequest.getLocation());
			resturant.setPhone(restaurantRequest.getPhone());
			if (restaurantRequest.getCategory().equalsIgnoreCase(BAR)
					|| restaurantRequest.getCategory().equalsIgnoreCase(CAFE)
					|| restaurantRequest.getCategory().equalsIgnoreCase(CLOUD_KITCHEN)
					|| restaurantRequest.getCategory().equalsIgnoreCase(TAKE_AWAY)) {

			resturant.setCategory(restaurantRequest.getCategory());
			}
			else {
				resturant.setCategory("Other");
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
		ResturantResponse resturantResponse = new ResturantResponse();
		Resturant resturant = resturantRepository.findByRestName(restaurantRequest.getRestName());
		if (!restaurantRequest.getStatus().equalsIgnoreCase(STATUS_APPROVED)
				|| !restaurantRequest.getStatus().equalsIgnoreCase(STATUS_NOT_APPROVED)) {
			resturantResponse.setMessage("Status should be Approved or Not Approved");
		}
		if (resturant != null) {
			resturant.setStatus(restaurantRequest.getStatus());
			resturant.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
			resturantRepository.save(resturant);
			resturantResponse.setMessage("Resturant information succssfully updated by Admin");
		} else {
			resturantResponse.setMessage("Resturant information doesn't exist");
		}
		return resturantResponse;
	}

}
