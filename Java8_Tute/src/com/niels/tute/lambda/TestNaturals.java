package com.niels.tute.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestNaturals {
	static List<Integer> naturals = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
	
	static void peek1() {
		List<Integer> intList = naturals.stream()
	    .map(n -> n * 2)
	    .peek(System.out::println)
	    .collect(Collectors.toList());
		
		intList.forEach(n -> System.out.println(n));
	}
	static void peek2() {
		naturals.stream()
	    .map(n -> n * 2)
	    .peek(elt -> System.out.println(elt))
	    .collect(Collectors.toList());
	}
	public static void main(String[] args) {
		
		peek1();
	}
}
