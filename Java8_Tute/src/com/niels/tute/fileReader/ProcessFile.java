package com.niels.tute.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * Demonstrates 'Execute Around Pattern" Ch 2 - Java in Action
 */
public class ProcessFile {
	private static String filePath = "";
	
	public static String processFile(BufferedReaderProcessor bp) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			return bp.process(br);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
	
	// Read file using forEach and Files.lines()
	public static void readAllLines(String filePath) {
		Path path = Paths.get(filePath);
		
		try (Stream<String>lines = Files.lines(path)) {
			lines.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		filePath = args[0];
		
		// Read one line
		String result1 = processFile((BufferedReader br) -> br.readLine());
		System.out.println(result1);
		// Read 2 lines
		result1 = processFile((BufferedReader br) -> br.readLine() +" "+ br.readLine());
		System.out.println(result1);
		
		// Read all lines
		readAllLines(filePath);
	}
}
