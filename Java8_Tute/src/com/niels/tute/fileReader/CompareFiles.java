package com.niels.tute.fileReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareFiles {

	
	public static void main(String[] args) {
		String file1 = args[0];
		String file2 = args[1];

		File nfile1 = new File(file1);
		File nfile2 = new File(file2);
		String baseFile1 = nfile1.getName();
		String baseFile2 = nfile2.getName();
		
		System.out.println(baseFile1);
		
		try {
			Stream<String> stream1 = Files.lines(Paths.get(file1));
			Stream<String> stream2 = Files.lines(Paths.get(file2));

			List<String> list1 = stream1.map(a -> a.toUpperCase()).collect(Collectors.toList());
			List<String> list2 = stream2.map(a -> a.toUpperCase()).collect(Collectors.toList());
			
			String result = compare(list1, list2, (String str1,List<String> l2) -> !(l2.contains(str1)));			
			System.out.println(String.format("Which elements of %s are NOT found in %s: %n%s", baseFile1, baseFile2, result) );

			result = compare(list1, list2, (String str1,List<String> l2) -> l2.contains(str1));			
			System.out.println(String.format("Which elements of %s are ALSO found in %s: %n%s", baseFile1, baseFile2, result) );
			
			result = compare(list2, list1, (String str1,List<String> l2) -> !l2.contains(str1));			
			System.out.println(String.format("Which elements of %s are NOT found in %s: %n%s", baseFile2, baseFile1, result) );
			
			stream1.close();
			stream2.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	private static String compare(List<String> list1, List<String> list2, ComparisonProcessor cp) {
		StringBuilder sb = new StringBuilder();
		
		for (String list1Str : list1) {
			if (cp.compare(list1Str, list2)) {
				sb.append(list1Str).append("\n");
			}
		}
		
		return sb.toString();
	}

}
