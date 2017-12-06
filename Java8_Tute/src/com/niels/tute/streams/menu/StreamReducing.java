package com.niels.tute.streams.menu;

import java.util.List;
import java.util.Optional;

public class StreamReducing {
	public static void main(String[] args ) {
		List<Dish> menu = StreamSources.menu;
		
		Optional<Dish> dish = menu.stream().findAny();
		Dish dishValue = dish.get();
		
		Optional<Dish> anyDish = menu.stream().findAny();
		
		List<Integer> numberList = StreamSources.numList;
		// Reducing the list to a sum using the reduce() method
		// reduce (initialvalue, (eltA, eltB) -> eltA + eltB)
		int sum = numberList.stream().reduce(0, (a,b) -> a + b);
		// Same as:
		sum = numberList.stream().reduce(0, Integer::sum);
		System.out.println("Sum of Numbers: " + sum);
		// reduce() with no initial value, but returns Optional
		
		Optional<Integer> sumOptional =  numberList.stream().reduce(Integer::sum);
		System.out.println("Sum of Numbers, again: " + sumOptional.get());
		
		int maxNum = numberList.stream().reduce(0, (a,b) -> {if (a > b) { return a;} else {return b;}});
		System.out.println("Max: " + maxNum);
		Optional<Integer> minNum =  numberList.stream().reduce(Integer::min);
		System.out.println("Min: " + minNum.get());
	}
}
