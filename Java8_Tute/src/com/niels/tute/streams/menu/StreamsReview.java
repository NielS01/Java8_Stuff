package com.niels.tute.streams.menu;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsReview {

	public static void main(String[] args) {
		List<Transaction> allTransactions = StreamSources.transactions;
		// 1.  Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> year2011Transactions = allTransactions.stream().filter(a -> a.getYear() == 2011).collect(Collectors.toList());
		System.out.println("2011 Transactions:");
		year2011Transactions.forEach(System.out::println);
		
		// 2.  What are all the unique cities where the traders work?
		List<String> uniqueCities = StreamSources.traderList.stream().map(a -> a.getCity()).distinct().collect(Collectors.toList());
		System.out.println("Unique Cities:");
		uniqueCities.forEach(System.out::println);

		// 3.  Find all traders from Cambridge and sort them by name.
		List<String> cambridgeTraderNames = StreamSources.traderList.stream()
				.filter(a -> a.getCity().equalsIgnoreCase("Cambridge"))
				.distinct()
				.map(a -> a.getName())
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Cambridge traders:");
		cambridgeTraderNames.forEach(System.out::println);
		
		  // or
		List <Trader>cambridgeTraders = StreamSources.transactions.stream()
				.map(Transaction::getTrader)
				.filter(a -> a.getCity().equalsIgnoreCase("Cambridge"))
				.distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		
		System.out.println("Cambridge traders:");
		cambridgeTraders.forEach(System.out::println);
		// 4.  Return a string of all traders’ names sorted alphabetically.
		String traderNames = StreamSources.traderList.stream()
									.sorted(Comparator.comparing(Trader::getName))
									.map(a -> a.getName())
									.reduce(" ", (n1, n2) -> n1 + " " + n2);
		System.out.println("all traders:" +traderNames);


		// 5.  Are any traders based in Milan?
		Boolean anyMilanTraders = StreamSources.transactions.stream()
								.map(Transaction::getTrader).anyMatch(trader -> trader.getCity().equalsIgnoreCase("Milan"));
		System.out.println("Are there traders in Milan? " +anyMilanTraders);
		
		// 6.  Print all transactions’ values from the traders living in Cambridge.
		System.out.println("Print all transactions’ values from the traders living in Cambridge.");
		StreamSources.transactions.stream()
				.filter(a -> a.getTrader().getCity().equalsIgnoreCase("Cambridge"))
				.distinct()
				.forEach(trans -> System.out.println(trans.getValue()));
		
		// 7.  What’s the highest value of all the transactions?
		Optional<Integer> max = StreamSources.transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		if (max.isPresent()) {
			System.out.println("Maximum transaction value is: " +max.get());
		}
		// 8.  Find the transaction with the smallest value.
		Optional<Integer> min = StreamSources.transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		if (min.isPresent()) {
			System.out.println("Min transaction value is: " +min.get());
		}
	}
}
