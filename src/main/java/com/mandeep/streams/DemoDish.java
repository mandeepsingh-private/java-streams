package com.mandeep.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoDish {
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH));
		System.out.println("Vegetarian Dishes: ");
		List<Dish> vegItems = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		vegItems.stream().forEach(System.out::println);
		System.out.println("########################");
		System.out.println("Low calorie dishes: ");
		// take while only works when stream is sorted, els return null
		List<Dish> items = menu.stream().sorted(new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return Integer.valueOf(o1.getCalories()).compareTo(Integer.valueOf(o2.getCalories()));
			}
		}).takeWhile(dish -> dish.getCalories() < 400).collect(Collectors.toList());
		items.stream().forEach(System.out::println);
	}
}