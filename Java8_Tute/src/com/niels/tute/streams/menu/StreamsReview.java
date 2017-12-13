package com.niels.tute.streams.menu;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsReview {

	public static void main(String[] args) {
		List<Transaction> allTransactions = StreamSources.transactions;
		// 1.  Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> year2011Transactions = allTransactions.stream().filter(a -> a.getYear() == 2011).collect(Collectors.toList());
		year2011Transactions.forEach(System.out::println);
		// 2.  What are all the unique cities where the traders work?

		// 3.  Find all traders from Cambridge and sort them by name.

		// 4.  Return a string of all traders’ names sorted alphabetically.

		// 5.  Are any traders based in Milan?

		// 6.  Print all transactions’ values from the traders living in Cambridge.

		// 7.  What’s the highest value of all the transactions?

		// 8.  Find the transaction with the smallest value.
	}
}
