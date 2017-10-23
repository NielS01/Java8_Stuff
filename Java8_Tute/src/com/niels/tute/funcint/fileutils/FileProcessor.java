package com.niels.tute.funcint.fileutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	
	static String processFile(String fileName, BufferedReaderProcessor pr) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			return pr.process(br);
		}
		
	}
	public static void main(String[] args) {
		if (args.length > 0) {
			String testFile = args[0];
			
			try {
				// this demostrates passing behaviour to implement the 'Execute Around pattern"
				String readOneLine = processFile(testFile, (BufferedReader br) -> br.readLine());
				System.out.println(readOneLine);
				String readTwoLines = processFile(testFile, (BufferedReader br) -> (br.readLine() + "\n" + br.readLine()));
				System.out.println(readTwoLines);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
