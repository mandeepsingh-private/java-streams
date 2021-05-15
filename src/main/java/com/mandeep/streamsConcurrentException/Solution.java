package com.mandeep.streamsConcurrentException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			list.add(i);

// gives concurrent exception
//		for (int i : list) {
//			if (i == 4) {
//				list.add(100);
//			}
//		}
		/*
		 * The sorted() operation is a “stateful intermediate operation”, which means
		 * that subsequent operations no longer operate on the backing collection, but
		 * on an internal state. It is now “safe” to remove elements from the list!
		 * 
		 */
		list.stream().sorted().forEach((s) -> {
			if (s == 4)
				list.add(100);
		});
		// or we can use collect method
		list.stream().collect(Collectors.toList()).forEach((s) -> {
			if (s == 99)
				list.add(200);
		});
		list.stream().forEach(System.out::println);
	}

}
