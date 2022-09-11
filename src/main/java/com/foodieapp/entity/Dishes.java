package com.foodieapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="dishes")
@Data
public class Dishes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dishId;
	
	@Column(name="restName")
	private String restName;
	
	@Column(name="restId")
	private Integer restId;
	
	@Column(name="dishName")
	private String dishName;
	
	@Column(name="dishPrice")
	private float dishPrice;
	
	@Column(name="NoOfOrders")
	private Integer NoOfOrders;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="updatedDate")
	private Date updatedDate;
	
	

}
