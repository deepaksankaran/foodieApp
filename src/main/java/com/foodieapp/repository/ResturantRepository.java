package com.foodieapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodieapp.entity.Resturant;
@Repository
public interface ResturantRepository extends JpaRepository<Resturant,Integer> {

	@Query(value="select * from resturant where rest_name=:resturantName",nativeQuery=true)
	Resturant findByRestName(String resturantName);


}
