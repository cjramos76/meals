package com.gft.test.meals.service;

import java.util.List;

import com.gft.test.meals.model.MealType;

public interface FoodService {
	String getFoodList(MealType mealType, List<Integer> order);
}
