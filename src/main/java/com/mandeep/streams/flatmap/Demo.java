package com.mandeep.streams.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] initialWords = { "hello", "world" };
		List<String> words = Arrays.asList(initialWords);
		// split the word and returns a list of string arrays
		List<String[]> answer = words.stream().map(word -> word.split("")).collect(Collectors.toList());
		// combines stream of arrays into one array
		List<String> finalAnswer = answer.stream().flatMap(Arrays::stream).collect(Collectors.toList());
		finalAnswer.stream().forEach(System.out::println);
	}

}
