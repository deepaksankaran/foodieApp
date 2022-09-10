package com.foodieapp.service;

import org.springframework.stereotype.Service;

import com.foodieapp.entity.User;
import com.foodieapp.model.UserRegRequest;
import com.foodieapp.model.UserRegResponse;

@Service
public interface UserService {

	UserRegResponse save(UserRegRequest userReqRequest);

	User getUserData(String userName);

}
