package com.foodieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodieapp.entity.Resturant;
@Repository
public interface ResturantRepository extends JpaRepository<Resturant,Integer> {

}
