package com.foodieapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodieapp.entity.User;
import com.foodieapp.model.UserRegRequest;
import com.foodieapp.model.UserRegResponse;
import com.foodieapp.service.UserService;

@RequestMapping("foodie")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	//save
	@PostMapping("/save")
	public ResponseEntity<UserRegResponse> save(@RequestBody UserRegRequest userReqRequest){
		UserRegResponse userRegResponse=new UserRegResponse();
		userRegResponse=userService.save(userReqRequest);		
		return new ResponseEntity<UserRegResponse>(userRegResponse,HttpStatus.OK);
	}
	//view
	@GetMapping("/get/{userName}")
	public ResponseEntity<User> getData(@PathVariable String userName) {
		User user=userService.getUserData(userName);
		System.out.println("userData"+user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	//update
	@PutMapping("/update")
	public ResponseEntity<UserRegResponse> update(@RequestBody UserRegRequest userReqRequest){
		UserRegResponse userRegResponse=new UserRegResponse();
		userRegResponse=userService.save(userReqRequest);		
		return new ResponseEntity<UserRegResponse>(userRegResponse,HttpStatus.OK);
		
	}
	//delete
	
	
}
