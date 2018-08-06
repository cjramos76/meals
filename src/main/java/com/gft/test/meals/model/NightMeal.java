package com.gft.test.meals.model;

public enum NightMeal {
	steak(1), potato(2), wine(3), cake(4);

	private final int code;

	private NightMeal(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static String getName(int code) {
		switch (code) {
		case 1:
			return NightMeal.steak.toString();
		case 2:
			return NightMeal.potato.toString();
		case 3:
			return NightMeal.wine.toString();
		case 4:
			return NightMeal.cake.toString();
		default:
			return null;
		}
	}


}
