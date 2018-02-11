package com.niels.wordUtils;

import java.util.ArrayList;
import java.util.stream.Stream;

public class WordFind {


	/*
	 *   {"a", "b", "e", "n", "f"},
		 {"x", "l", "d", "x", "f"},
		 {"a", "b", "i", "x", "f"},
	     {"a", "b", "d", "e", "f"},
		 {"a", "b", "d", "x", "n"}
	 */
	// May incorporate with a dictionary some day
	static WordDictionary wordList = new WordDictionary();
	static Boolean isAWord(String word) {
		Stream<String> words = wordList.getDictionaryWordList().stream();
		if (words != null && words.anyMatch(str -> str.equalsIgnoreCase(word))) {
			return true;
		}
		return false;
	}
	

	// Return a list of strings from current position to forward end
	static ArrayList<String> findWordsByDir(String[][] wordMatrix, int x, int y, FindNextCoordinates findCoord) {
		String currentChar = wordMatrix[y][x];
		ArrayList<String> forwardWords = new ArrayList<String>();
		String nextChar;
		
		int xCurr = x;
		int yCurr = y;
		StringBuilder sb = new StringBuilder();
		sb.append(currentChar);
		// while next coordinates still in bounds, keep going in that direction
		while (true) {
			Coordinates next = findCoord.next(xCurr, yCurr);			
			try {
				nextChar = wordMatrix[next.getY()][next.getX()];   
				sb.append(nextChar);
				String nextWord = sb.toString();
				if (isAWord(nextWord)) {
					forwardWords.add(sb.toString());
				}				
			} catch (ArrayIndexOutOfBoundsException e) { 
				// No way of telling the dimensions of a 2D array, just catch the exception
				break;
			}
			xCurr = next.getX();
			yCurr = next.getY();
			
		}
			
		return forwardWords;	
	}
	
	String[] findWords(String[][] wordMatrix, int x, int y) {
		return null;
	}
	
	static void printMatrix(String[][] wordMatrix) {
		int length = wordMatrix.length;
		int idx = 0;
		
		for (idx = 0; idx < length; idx ++) {
			for(String str : wordMatrix[idx]) {
				System.out.print(str +" ");
			}
			System.out.println("");
		}
	}
	
	

	public static void main(String[] args) {
		String[][] wordMatrix = WordMatrix.squreMatrix1;

		FindNextCoordinates forward = (x,y)->new Coordinates(x+1,y);
		FindNextCoordinates diagDown = (x,y)->new Coordinates(x+1,y+1);
		FindNextCoordinates backward = (x,y)->new Coordinates(x-1,y);
		FindNextCoordinates down = (x,y)->new Coordinates(x,y+1);
		FindNextCoordinates up = (x,y)->new Coordinates(x,y-1);
		FindNextCoordinates diagUp = (x,y)->new Coordinates(x-1,y-1);
		FindNextCoordinates diagDown2 = (x,y)->new Coordinates(x-1,y+1);
		
		printMatrix(wordMatrix);
		int xCoor = 0;
		int yCoor = 0;
		
		ArrayList<String> forwardWords = findWordsByDir(wordMatrix, xCoor,yCoor, forward);
		System.out.println("\nDirection forwards:");
		forwardWords.forEach(System.out::println);
		
		ArrayList<String> diagDownWords = findWordsByDir(wordMatrix, xCoor,yCoor, diagDown);
		System.out.println("\nDirection diagonalDown:");
		diagDownWords.forEach(System.out::println);
		
		ArrayList<String> backwardWords = findWordsByDir(wordMatrix, 4,3, backward);
		System.out.println("\nDirection backward:");
		backwardWords.forEach(System.out::println);
		
		ArrayList<String> downdWords = findWordsByDir(wordMatrix, xCoor, yCoor, down);
		System.out.println("\nDirection downdWords:");
		downdWords.forEach(System.out::println);
		
		ArrayList<String> upWords = findWordsByDir(wordMatrix, 2,4, up);
		System.out.println("\nDirection up:");
		upWords.forEach(System.out::println);
		
	    ArrayList<String> diagUpWords = findWordsByDir(wordMatrix, 4,4, diagUp);
	    System.out.println("\nDirection diagonalUp:");
	    diagUpWords.forEach(System.out::println);
	    
	    ArrayList<String> diagDownWords2 = findWordsByDir(wordMatrix, 4,0, diagDown2);
	    System.out.println("\nDirection diagonalDown2:");
	    diagDownWords2.forEach(System.out::println);
	    
	}
}

