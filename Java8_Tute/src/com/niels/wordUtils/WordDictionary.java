package com.niels.wordUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordDictionary {
	static String dictionaryFile = "C:\\Users\\mbfuser\\git\\Java8_Stuff\\Java8_Tute\\Test_Data\\tute\\wordUtils\\words.txt";
	
	List<String> dictionaryWordList;
	
	List<String> getDictionaryWordList() {
		if (dictionaryWordList == null) {
			try {
				Stream<String> words = Files.lines(Paths.get(dictionaryFile));
				dictionaryWordList = words.collect(Collectors.toList()); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return dictionaryWordList;
	}
	
}
