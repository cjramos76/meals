package com.gft.test.meals;

import com.gft.test.meals.controller.MealController;
import com.gft.test.meals.controller.impl.MealControllerImpl;

public class Meal {

	public static void main(String[] args) {
		MealController mealController = new MealControllerImpl();
		System.out.println(mealController.orderFood(args));
	}

}
