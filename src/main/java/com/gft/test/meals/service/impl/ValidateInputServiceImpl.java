package com.gft.test.meals.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.test.meals.model.MealType;
import com.gft.test.meals.service.ValidateInputService;

public class ValidateInputServiceImpl implements ValidateInputService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final int POTATO = 2;
	private static final int COFFEE = 3;

	public boolean validate(String...args) {
		logger.info("validate input");
		boolean isValid = true;
		if (args != null && args.length == 1) {
			String[] order = args[0].split(",");
			if (order.length < 2) {
				logger.error("Error: invalid number of params (example: night,1");
				isValid = false;
			} else {
				String mealType = order[0];
				if (!MealType.MORNING.toString().toUpperCase().equals(mealType.toUpperCase()) && 
						!MealType.NIGHT.toString().toUpperCase().equals(mealType.toUpperCase())) {
					logger.error("Error: value of first param is night or morning (example: night,1");
					isValid = false;
				} else {
					
					List<String> orderList = Arrays.asList(order).subList(1, order.length);
					MealType mealTypeEnum = MealType.getMealType(order[0]);
					
					isValid = this.validateFoodOrderNumber(order,
							mealTypeEnum.equals(MealType.MORNING) ? COFFEE : POTATO);
				}
			} 
		} else {
			isValid = false;
		}
		logger.info("input is correct {}", isValid);
		return isValid;
	}

	private boolean validateFoodOrderNumber(String[] orderList, int multipleFood) {
		boolean isValid = true;
		Map<Integer, Long> foodOrderList = Arrays.asList(orderList).subList(1, orderList.length).stream()
				.map(Integer::parseInt).sorted().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		for (long order :foodOrderList.keySet().stream().filter(s -> s != multipleFood).map(s -> foodOrderList.get(s)).collect(Collectors.toList())) {
			if (order > 1) {
				isValid = false;
				logger.error("Error: you only can order more than one potato or coffee (example: night,1,2,2");
				break;
			}
		}
		
		return isValid;
	}


}
