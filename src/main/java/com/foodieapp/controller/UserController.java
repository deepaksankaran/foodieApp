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

import com.foodieapp.entity.User;
import com.foodieapp.model.UserRegRequest;
import com.foodieapp.model.UserResponse;
import com.foodieapp.service.UserService;

@RequestMapping("foodie")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	//save
	@PostMapping("/save")
	public ResponseEntity<UserResponse> save(@RequestBody UserRegRequest userReqRequest){
		UserResponse userRegResponse=userService.save(userReqRequest);		
		return new ResponseEntity<UserResponse>(userRegResponse,HttpStatus.OK);
	}
	//get user  by username
	@GetMapping("/get/{userName}")
	public ResponseEntity<User> getUser(@PathVariable String userName) {
		User user=userService.getUserData(userName);
		System.out.println("userData"+user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	//get All users
	@GetMapping("/get/users")
	public List<User> getUsers() {
		List<User> users=userService.getAllUsers();
		return users;
	}
	//update by user Id
	@PutMapping("/update")
	public ResponseEntity<UserResponse>  update(@RequestBody UserRegRequest userReqRequest){
		UserResponse userResponse=userService.update(userReqRequest);		
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);
	}
	//delete
	@DeleteMapping("/delete")
	public ResponseEntity<UserResponse> delete(@RequestBody UserRegRequest userReqRequest){
		UserResponse userRegResponse=userService.delete(userReqRequest);		
		return new ResponseEntity<UserResponse>(userRegResponse,HttpStatus.OK);
	}
	
}
