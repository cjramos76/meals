package com.gft.test.meals.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.test.meals.controller.MealController;
import com.gft.test.meals.model.MealType;
import com.gft.test.meals.service.FoodService;
import com.gft.test.meals.service.ValidateInputService;
import com.gft.test.meals.service.impl.FoodServiceImpl;
import com.gft.test.meals.service.impl.ValidateInputServiceImpl;


public class MealControllerImpl implements MealController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
			
	public String orderFood(String[] args) {
		logger.info("ordering food");
		ValidateInputService validateInputService = new ValidateInputServiceImpl();

		if (validateInputService.validate(args)) {
			FoodService foodService = new FoodServiceImpl();
			MealType mealType = getMealType(args);
			List<Integer> orderList = getOrderList(args);
			String resultado = foodService.getFoodList(mealType, orderList);
			return resultado;
		} else {
			return "Error input params";
		}

	}

	private static MealType getMealType(String[] args) {
		String[] order = args[0].split(",");
		return MealType.getMealType(order[0]);
	}

	private static List<Integer> getOrderList(String[] args) {
		String[] order = args[0].split(",");
		System.out.println(Arrays.asList(order).subList(1, order.length).stream().map(String::trim).map(Integer::parseInt).sorted()
				.collect(Collectors.toList()));
		return Arrays.asList(order).subList(1, order.length).stream().map(String::trim).map(Integer::parseInt).sorted()
				.collect(Collectors.toList());
	}
}
