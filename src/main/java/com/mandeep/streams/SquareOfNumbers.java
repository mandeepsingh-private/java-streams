package com.mandeep.streams;

import java.util.Arrays;

public class SquareOfNumbers {

	public static void main(String[] args) {
		int[] list = { 1, 2, 3, 4, 5 };

		Arrays.stream(list).map(i -> i * i).forEach(System.out::println);
	}

}
