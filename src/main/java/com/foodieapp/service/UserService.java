package com.foodieapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodieapp.entity.User;
import com.foodieapp.model.UserRegRequest;
import com.foodieapp.model.UserResponse;

@Service
public interface UserService {

	UserResponse save(UserRegRequest userReqRequest);

	User getUserData(String userName);

	List<User> getAllUsers();

	UserResponse update(UserRegRequest userReqRequest);

	UserResponse delete(UserRegRequest userReqRequest);

}
