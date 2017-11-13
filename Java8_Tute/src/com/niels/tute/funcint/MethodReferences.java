package com.niels.tute.funcint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
	
	static void covertToIntAndDouble(Function<String, Integer> ft, String t) {
		Integer result = ft.apply(t)*2;
		System.out.println(result);
	}
	
	static void welcomePartyGuest(BiPredicate<List<String>, String> funcRef, List<String> inviteList, String newcommer) {
		if (funcRef.test(inviteList, newcommer)) {
			System.out.println("Welcome to the party, " +newcommer);
		} else {
			System.out.println("You're gate crashing, " +newcommer);
		}
	}
	public static void main(String[] args) {
		Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		// above is same as below, using method reference
		covertToIntAndDouble(stringToInteger, "5");
		Function<String, Integer> stringToInteger2 = Integer::parseInt;
		covertToIntAndDouble(stringToInteger2, "20");
		
		List<String> partyList= new ArrayList<String>();
		partyList.add("Danno");
		partyList.add("Bruce");
		partyList.add("Trevor");
		
		BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
		BiPredicate<List<String>, String> contains2 = List::contains;
		
		welcomePartyGuest(contains2, partyList, "James");
		welcomePartyGuest(contains2, partyList, "Danno");
		
		// Constructor references
		Supplier<Apple> c1 = Apple::new;
		Apple a1 = c1.get();
		Function<Integer,Apple> c2 = (Integer wt) ->  new Apple(wt);
		Function<Integer,Apple> c3 = Apple::new;
		
	}
	
	static class Apple {
		final static Integer DefaultWeight = 50; // grams
		final static String DefaultColour = "red";
		
		private Integer weight;
		private String colour;
		
		Apple() {
			weight = DefaultWeight;
			colour = DefaultColour;
		}
		Apple(Integer wt) {
			weight = wt;
			colour = DefaultColour;
		}
		public Integer getWeight() {
			return weight;
		}
		public void setWeight(Integer weight) {
			this.weight = weight;
		}
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		
	}
}
