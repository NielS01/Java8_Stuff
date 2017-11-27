package com.niels.tute.streams.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {

	
	
	static public void main(String[] args) {
	    List<String>wordList =  Arrays.asList("This", "is", "a", "list", "of", "words");
		List<Integer> wordListLen = wordList.stream().map(String::length).collect(Collectors.toList());
		
		wordListLen.forEach(System.out::println); // Prints out the length of each word in the wordList
		
		// Now we want to return the list of all unique characters from the wordList
		// Initial solution: doesn't work because it returns a List of String[]
		List<String[]> stringLst = wordList.stream().map(w -> w.split("")).distinct().collect(Collectors.toList());

		for (String[] strArray : stringLst) {
			for (String str : strArray) {
				System.out.println(str);
			}
		}
		
		List<String> unqCharacters = wordList.stream()
										.map(w -> w.split("")) // Stream<String[]> : since split returns String[]
										.flatMap(Arrays::stream) // replace each value of a stream with another 
																 // stream then concatenates all the generated streams 
																 // into a single stream
										.distinct()
										.collect(Collectors.toList());
		unqCharacters.forEach(System.out::println);
		
		// Quiz 1: Given a list of numbers, how would you return a list of the square of each number?
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		
		List<Integer> squares = intList.stream().map(d -> d*d).collect(Collectors.toList());
		System.out.println("Printing squarenums");
		squares.forEach(System.out::println);
		
		// Quiz 2: Given two lists of numbers, how would you return all pairs of numbers?
		List<Integer> intList1 = Arrays.asList(1, 2, 3);
		List<Integer> intList2 = Arrays.asList(3, 4);
		
		List<int[]> pairs = intList1.stream()
							.flatMap(i -> intList2.stream()
			                                  .map(j -> new int[]{i, j})
			                    )
							.collect(Collectors.toList());
		
	}
	
}
