package com.gft.test.meals.model;

public enum MealType {
	MORNING("morning"), NIGHT("night");

	private final String name;

	private MealType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public static MealType getMealType(String mealType) {
		switch (mealType) {
		case "morning":
			return MealType.MORNING;
		case "night":
			return MealType.NIGHT;
		default:
			return null;
		}
	}
}
