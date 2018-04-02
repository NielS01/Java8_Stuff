package com.niels.wordUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Finds all the words in a matrix in every direction (up, down, forward, backward, diagonal (up down left right)
 */
public class WordFind {

	// May incorporate with a dictionary some day
	static WordDictionary wordList = new WordDictionary();

	/*
	 *  Use binary search to find the word
	 */
	static Boolean isAWord(String word) {
		List<String> words = wordList.getDictionaryWordList();
		if (word.length() <= 2) { // ignore 2 letter words
			return false;
		}
		int index = Collections.binarySearch(words, word, String::compareToIgnoreCase);
		if (index > 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * This was a slow sequential search
	 */
	static Boolean isAWord2(String word) {
		List<String> words = wordList.getDictionaryWordList();
		if (words != null && words.contains(word)) {
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
	
	static void printWordsAtAllCoords(String[][] wordMatrix) {
		int length = wordMatrix.length;
		List<String> newList = new ArrayList<String>();
		
		for (int y = 0; y < length; y++) {
			int eltLength = wordMatrix[y].length;
			for (int x = 0; x < eltLength; x++) {
				newList.addAll(printWordsAtCoord(wordMatrix, x, y));
			}
		}
		List<String> resultList = newList.stream().distinct().sorted().collect(Collectors.toList());
		int ctr = 0;
		for (String str : resultList) {
			System.out.println(String.format("%d) %s", ++ctr, str));
		}
	}
	static List<String> printWordsAtCoord(String[][] wordMatrix, int xCoor, int yCoor) {
		FindNextCoordinates forward = (x,y)->new Coordinates(x+1,y);
		FindNextCoordinates backward = (x,y)->new Coordinates(x-1,y);
		
		FindNextCoordinates diagDownRight = (x,y)->new Coordinates(x+1,y+1);
		FindNextCoordinates diagDownLeft = (x,y)->new Coordinates(x-1,y+1);
		
		FindNextCoordinates down = (x,y)->new Coordinates(x,y+1);
		FindNextCoordinates up = (x,y)->new Coordinates(x,y-1);
		
		FindNextCoordinates diagUpLeft = (x,y)->new Coordinates(x-1,y-1);
		FindNextCoordinates diagUpRight = (x,y)->new Coordinates(x+1,y-1);
		
		ArrayList<String> forwardWords = findWordsByDir(wordMatrix, xCoor,yCoor, forward);
		ArrayList<String> diagDownWords = findWordsByDir(wordMatrix, xCoor,yCoor, diagDownRight);
		ArrayList<String> backwardWords = findWordsByDir(wordMatrix,  xCoor,yCoor, backward);
		ArrayList<String> downdWords = findWordsByDir(wordMatrix, xCoor, yCoor, down);
		ArrayList<String> upWords = findWordsByDir(wordMatrix,  xCoor,yCoor, up);
	    ArrayList<String> diagUpWords = findWordsByDir(wordMatrix,  xCoor,yCoor, diagUpLeft);
	    ArrayList<String> diagUpRightWords = findWordsByDir(wordMatrix,  xCoor,yCoor, diagUpRight);	    
	    ArrayList<String> diagDownWords2 = findWordsByDir(wordMatrix,  xCoor,yCoor, diagDownLeft);
	    
	    List<String> result2 = Stream.of(forwardWords,diagDownWords,backwardWords,downdWords,upWords,diagUpWords, diagUpRightWords, diagDownWords2).flatMap(Collection::stream).collect(Collectors.toList());
	    return result2;
	}

	private static String[][] readMatrixFromFile(String inFile)  {
		String[][] resultMatrix;
		Stream<String> lines;
		try {
			lines = Files.lines(Paths.get(inFile));
			List<String[]> matrixList = lines.map(line -> line.split(" ")).collect(Collectors.toList()); // Now we have a list of String[]
			int len = matrixList.size();
			resultMatrix = new String[len][len];
			
			int ctr = 0;
			for(String[] strArray : matrixList) {
				resultMatrix[ctr++] = strArray;
			}
			lines.close();
			return resultMatrix;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(String.format("Unable to read file[%s]", inFile));
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String[][] wordMatrix;
		if (args.length > 0) {
			String inFile = args[0];
			wordMatrix = readMatrixFromFile (inFile);
		} else {
			wordMatrix = WordMatrix.squreMatrix1;
		}
		
		if (wordMatrix != null) {
			printMatrix(wordMatrix);
			printWordsAtAllCoords(wordMatrix);
		}

	}
}

