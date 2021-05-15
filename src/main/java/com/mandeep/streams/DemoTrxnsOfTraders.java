package com.mandeep.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DemoTrxnsOfTraders {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

		System.out.println("#########################");
		System.out.println("All trxns in year 2011 :");
		// find all trxns in year 2011 and sort them by value
		List<Transaction> trxns = transactions.stream()
				.sorted(new Comparator<Transaction>() {
					@Override
					public int compare(Transaction o1, Transaction o2) {
						return Integer.valueOf(o1.getValue())
								.compareTo(Integer.valueOf(o2.getValue()));
					}
				}).filter(t -> t.getYear() == 2011)
				.collect(Collectors.toList());
		trxns.stream().forEach(System.out::println);

		System.out.println("#########################");
		System.out.println("Unique cities where traders work :");
		// unique cities where traders work
		List<String> cities = transactions.stream()
				.map(e -> e.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		cities.stream().forEach(System.out::println);

		System.out.println("#########################");
		System.out.println("All traders from Cambridge :");
		// find all traders from Cambridge and sort them
		List<String> tradersFromCambridge = transactions.stream()
				.filter(t -> t.getTrader().getCity() == "Cambridge")
				.map(t -> t.getTrader().getName()).distinct().sorted()
				.collect(Collectors.toList());
		tradersFromCambridge.stream().forEach(System.out::println);

		System.out.println("#########################");
		System.out.println("All traders names :");
		// find all traders name and sort them
		List<String> tradersNames = transactions.stream()
				.map(t -> t.getTrader().getName()).sorted().distinct()
				.collect(Collectors.toList());
		tradersNames.stream().forEach(System.out::println);
		// are there any traders based in Milan
		System.out.println("#########################");
		System.out.println("Traders based in Milan :");
		Optional<Transaction> milanTraders = transactions.stream()
				.filter(t -> t.getTrader().getCity() == "Milan").findAny();
		milanTraders.ifPresent(System.out::println);
	}

}
