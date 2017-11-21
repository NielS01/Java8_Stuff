package com.niels.tute.streams.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
	static List<Dish> menu = Arrays.asList(
		    new Dish("pork", false, 800, Dish.Type.MEAT),
		    new Dish("beef", false, 700, Dish.Type.MEAT),
		    new Dish("chicken", false, 400, Dish.Type.MEAT),
		    new Dish("french fries", true, 530, Dish.Type.OTHER),
		    new Dish("rice", true, 350, Dish.Type.OTHER),
		    new Dish("season fruit", true, 120, Dish.Type.OTHER),
		    new Dish("pizza", true, 550, Dish.Type.OTHER),
		    new Dish("prawns", false, 300, Dish.Type.FISH),
		    new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static void main(String[] args) {
		// Stream operations
		// 1. filter
		// 2. map
		// 3. limit
		// 4. collect- terminal operation
		
		// Print name of first 2 meat dishes
		List <String> twoMeatDishes = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT)).map(Dish::getName).limit(2).collect(Collectors.toList());
		System.out.println(twoMeatDishes.toString());
		List <String> allMeatDishes = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT)).map(Dish::getName).collect(Collectors.toList());
		System.out.println(allMeatDishes);
		
		// Use other collectors
		
		// 1 - joining
		String colonSeparatedPdishes = menu.stream().filter(d->d.getName().startsWith("p")).
				map(Dish::getName).collect(Collectors.joining(":"));
		System.out.println(colonSeparatedPdishes); //pork:pizza:prawns
		
		// 2 - summingInt
		int caloriesTotalFishDish = menu.stream().filter(d->d.getType().equals(Dish.Type.FISH)).collect(Collectors.summingInt(Dish::getCalories));
		System.out.println(String.format("Calories total for fish dishes = [%d]", caloriesTotalFishDish));
		
		Map<Dish.Type, List<Dish>> byDishType = menu.stream().collect(Collectors.groupingBy(Dish::getType));
		// Print by dish type
		// see: https://www.mkyong.com/java8/java-8-foreach-examples/
		byDishType.forEach((k,v)-> {System.out.println(k.name() +":" ); 
							v.forEach(d -> System.out.println("\t"+d.getName())); });
	}
}
