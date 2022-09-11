package com.foodieapp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	private String status;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="updatedDate")
	private Date updatedDate;

    @OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="restId",referencedColumnName ="restId")
	private List<Dishes> dishes;
}
