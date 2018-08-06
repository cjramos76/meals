package com.gft.test.meals.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.test.meals.model.MealType;
import com.gft.test.meals.model.MorningMeal;
import com.gft.test.meals.model.NightMeal;
import com.gft.test.meals.service.FoodService;

public class FoodServiceImpl implements FoodService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String ERROR = "error";
	
	public String getFoodList(MealType mealType, List<Integer> mealList) {
		
		logger.info("get food list");
		String result = null;
		if (mealType == MealType.NIGHT) {
			result = mealList.stream().sorted().map(s -> s<=4 ? NightMeal.getName(s):ERROR).collect(Collectors.joining(","));
		} else if (mealType == MealType.MORNING) {
			result = mealList.stream().sorted().map(s -> s<=3 ? MorningMeal.getName(s) : ERROR).collect(Collectors.joining(","));
		}
		logger.info("food list {} ", result);
		return result;
	}
}

