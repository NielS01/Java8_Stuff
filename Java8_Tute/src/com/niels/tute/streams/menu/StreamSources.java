package com.niels.tute.streams.menu;

import java.util.Arrays;
import java.util.List;

public class StreamSources {
	public static List<Integer> numList = Arrays.asList (4, 5, 6, 7, 8, 11);
	
	public static List<Dish> menu = Arrays.asList(
		    new Dish("pork", false, 800, Dish.Type.MEAT),
		    new Dish("beef", false, 700, Dish.Type.MEAT),
		    new Dish("chicken", false, 400, Dish.Type.MEAT),
		    new Dish("french fries", true, 530, Dish.Type.OTHER),
		    new Dish("rice", true, 350, Dish.Type.OTHER),
		    new Dish("season fruit", true, 120, Dish.Type.OTHER),
		    new Dish("pizza", true, 550, Dish.Type.OTHER),
		    new Dish("prawns", false, 300, Dish.Type.FISH),
		    new Dish("salmon", false, 450, Dish.Type.FISH) );
	
	public static Trader raoul = new Trader("Raoul", "Cambridge");
	public static Trader mario = new Trader("Mario","Milan");
	public static Trader alan = new Trader("Alan","Cambridge");
	public static Trader brian = new Trader("Brian","Cambridge");

	public static List<Transaction> transactions = Arrays.asList(
	    new Transaction(brian, 2011, 300),
	    new Transaction(raoul, 2012, 1000),
	    new Transaction(raoul, 2011, 400),
	    new Transaction(mario, 2012, 710),
	    new Transaction(mario, 2012, 700),
	    new Transaction(alan, 2012, 950)
	);
	
	public static List<Trader> traderList = Arrays.asList(raoul, mario, alan, brian);
}
