package com.foodieapp.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodieapp.entity.User;
import com.foodieapp.model.UserRegRequest;
import com.foodieapp.model.UserResponse;
import com.foodieapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponse save(UserRegRequest userReqRequest) {
		UserResponse userRegResponse = new UserResponse();
		User userData = userRepository.findByUserName(userReqRequest.getUserName());

		if (userData == null) {
			User user = new User();
			user.setFirstName(userReqRequest.getFirstName());
			user.setLastName(userReqRequest.getLastName());
			user.setLocation(userReqRequest.getLocation());
			user.setPhone(userReqRequest.getPhone());
			user.setDob(userReqRequest.getDob());
			user.setUserName(userReqRequest.getUserName());
			user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			userRepository.save(user);
			userRegResponse.setMessage("User information succssfully saved");
		} else {
			userRegResponse.setMessage("User information already exist");
		}
		return userRegResponse;
	}

	@Override
	public User getUserData(String userName) {
		User userResponse = userRepository.findByUserName(userName);
		return userResponse;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = userRepository.findAll();
		return usersList;
	}

	@Override
	public UserResponse update(UserRegRequest userReqRequest) {
		UserResponse userResponse = new UserResponse();
		User userData = userRepository.findByUserName(userReqRequest.getUserName());
		if (userData == null) {
			userResponse.setMessage("User information doesn't exist");
		} else {
			userData.setFirstName(userReqRequest.getFirstName());
			userRepository.save(userData);
			userResponse.setMessage("User information is successfully updated");
		}
		return userResponse;
	}

	@Override
	public UserResponse delete(UserRegRequest userReqRequest) {
		UserResponse userResponse = new UserResponse();
		User userData = userRepository.findByUserName(userReqRequest.getUserName());
		if (userData == null) {
			userResponse.setMessage("User information doesn't exist");
		} else {
			userRepository.delete(userData);
			userResponse.setMessage("User information is successfully deleted");
		}

		return userResponse;
	}

}
