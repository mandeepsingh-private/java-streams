package com.mandeep.hackerrank.substringComparison;

public class SolutionUsingUtils {
	public static String getSmallestAndLargest(String s, int k) {

		String smallest = "";
		String largest = "";
		int len = s.length() - k;
		int i = 0;
		java.util.ArrayList<String> words = new java.util.ArrayList<String>();
		while (i <= len) {
			String word = s.substring(i, i + k);
			words.add(word);
			i++;
		}
		java.util.Collections.sort(words);

		smallest = words.get(0);
		largest = words.get(words.size() - 1);
		System.out.println(words);
		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {

		System.out.println(getSmallestAndLargest("welcomeToJava", 3));
	}

}
