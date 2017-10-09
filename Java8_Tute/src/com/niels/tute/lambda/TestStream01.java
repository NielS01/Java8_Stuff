package com.niels.tute.lambda;

import java.io.InputStream;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream01 {
	private static final String REGEX_SEPARATOR = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"; // split on the comma only if that comma has zero, or an even number of quotes ahead of it.
	private static String	inFile	= null;
	
	static List<Person> readPersonFile(String fName) {
		InputStream is;
		try {
				is = new FileInputStream(new File(fName));
				BufferedReader br = new BufferedReader(new InputStreamReader(is));			 
				
				List<Person> persons =  br.lines(). // returns a Stream
										map((element) -> {return new Person((String) element, REGEX_SEPARATOR);}). // map each element to a Person
										collect(Collectors.toList()); // collect to a list
				
				return persons;
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}
	
	static List<Person> readPersonFileDebug(String fName) {
		InputStream is;
		try {
				is = new FileInputStream(new File(fName));
				BufferedReader br = new BufferedReader(new InputStreamReader(is));			 
				
				List<Person> persons =  br.lines(). // returns a Stream
										map((element) -> {return new Person((String) element, REGEX_SEPARATOR);}). // map each element to a Person
										peek(System.out::println).
										collect(Collectors.toList()); // collect to a list
				
				return persons;
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return null;
	}
	static void usage ()
	{
		System.out.println ("Usage: TestStream01 -i <input file>");
		System.exit (1);
	}
	
	static void parseArgs (String[] args)
	{
		inFile = null;

		for (int i = 0; i < args.length; i++)
		{
			String param = args[i];
			if ((param.compareToIgnoreCase ("-i") == 0) && (i + 1 < args.length))
			{
				inFile = args[++i];
			}
			
		}

		if (inFile == null)
			usage ();

		File input = new File (inFile);
		// File output = new File (outFile);
		if (!input.isFile ())
		{
			System.out.println ("Input file is not valid");
			usage ();
		}

	}
	public static void main(String[] args)
	{
		parseArgs(args);
		System.out.println("Loading data from:" + inFile);
		
		List<Person> persons = readPersonFile(inFile);
		
		for (Person p : persons)
		{
			System.out.println(p.getName() +", age: "+ p.getAge());
		}
		
		readPersonFileDebug(inFile);
	}
}
