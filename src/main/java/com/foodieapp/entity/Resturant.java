package com.foodieapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="resturant")
@Data
public class Resturant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restId;
	
	@Column(name="restName")
	private String restName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="location")
	private String location;
	
	@Column(name="status")
	private String status;//approved,not approved
}
