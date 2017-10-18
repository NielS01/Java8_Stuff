package com.niels.tute.lambda;

import java.util.Comparator;
import java.util.function.Predicate;

public class HelloLambda {

	public static void main(String[] args) {
		/*
		 * 2 syntax of lambdas
		 *  () -> expression
		 *  () -> {statments;}
		 */
		Comparator<String> stringComparator = (String s1, String s2) -> s1.compareTo(s2);
		/* 
		 * Functional Interface : Interface which specifies exactly one ABASTRACT method
		 * An interface is still a functional interface if it has many default methods 
		 * as long as it specifies only one abstract method
		 */
		// Predicate<Integer> greaterThanZero = (Integer a) -> a > 0;
		Integer x = -2;
		if (compareInt((Integer a) -> a > 0, x)) {
			System.out.println(x +" is greater than 0");
		} else {
			System.out.println(x +" is NOT greater than 0");
		}

	}
	
	static boolean compareInt(Comparem p, Integer x) {
		return p.greaterThanZero(x);
	}
	
	@FunctionalInterface
	interface Comparem {
		boolean greaterThanZero(Integer a);
	}
}
