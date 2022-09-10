package com.foodieapp.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodieapp.entity.User;
import com.foodieapp.model.UserRegRequest;
import com.foodieapp.model.UserRegResponse;
import com.foodieapp.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserRegResponse save(UserRegRequest userReqRequest) {
		UserRegResponse userRegResponse=new UserRegResponse();
		User user=new User();
		user.setFirstName(userReqRequest.getFirstName());
		user.setLastName(userReqRequest.getLastName());
		user.setLocation(userReqRequest.getLocation());
		user.setPhone(userReqRequest.getPhone());
		user.setUserId(userReqRequest.getUserId());
		user.setUserName(userReqRequest.getUserName());
		user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
		userRepository.save(user);
		return userRegResponse;
	}

	@Override
	public User getUserData(String userName) {
		// TODO Auto-generated method stub
		User userResponse=	userRepository.findByUserName(userName);
		return userResponse;
	}

}
