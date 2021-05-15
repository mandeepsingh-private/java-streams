package com.mandeep.hackerrank.substringComparison;

public class Solution {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		int len = s.length() - k;
		int i = 0;
		String[] words = new String[len + 1];
		while (i <= len) {
			String word = s.substring(i, i + k);
			if (word.isEmpty()) {
				break;
			}
			words[i] = word;
			i++;
		}
		// bubble sort
		boolean sorted = false;
		int unSortedlength = words.length - 1;
		while (!sorted) {
			sorted = true;
			i = 0;
			while (i < unSortedlength) {
				// System.out.println(words[i] + " " + words[i + 1]);
				// System.out.println(words[i].compareTo(words[i + 1]));
				if (words[i].compareTo(words[i + 1]) > 0) {
					sorted = false;
					String temp = words[i];
					words[i] = words[i + 1];
					words[i + 1] = temp;
				}
				// System.out.println("after " + words[i] + " " + words[i + 1]);
				i++;
			}
			unSortedlength = unSortedlength - 1;
			// System.out.println("unsorted reduced " + unSortedlength);
		}
		while (i < len + 1) {
			System.out.print(words[i] + " ,");
			i++;
		}
		System.out.println("\n----------------");
		smallest = words[0];
		largest = words[words.length - 1];

		return smallest + "\n" + largest;
	}

	public static void main(String[] args) {

		System.out.println(getSmallestAndLargest("welcomeToJava", 3));
	}
}