package com.gft.test.meals.model;

public enum MorningMeal {
	eggs(1),
	toast(2),
	coffee(3);
	
	private final int code;
	
	private MorningMeal(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static String getName(int code) {
		switch (code) {
		case 1:
			return MorningMeal.eggs.toString();
		case 2:
			return MorningMeal.toast.toString();
		case 3:
			return MorningMeal.coffee.toString();
		default:
			return null;
		}
	}


}
