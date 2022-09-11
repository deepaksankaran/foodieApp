package com.foodieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodieapp.entity.Dishes;

@Repository
public interface DishesRepository extends JpaRepository<Dishes, Integer> {

	@Query(value="select * from dishes where rest_name=:restName and dish_name=:dishName",nativeQuery = true)
	Dishes findByRestNameAndDishName(String restName, String dishName);


}
