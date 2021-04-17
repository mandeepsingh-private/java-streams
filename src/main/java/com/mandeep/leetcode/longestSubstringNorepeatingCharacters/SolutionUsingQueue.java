package com.mandeep.leetcode.longestSubstringNorepeatingCharacters;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionUsingQueue {
	public int lengthOfLongestSubstring(String s) {
		int arr[] = new int[256]; // Array to save ASCII values of all characters
		Queue<Character> queue = new LinkedList<Character>();
		int max = 0;
		for (char c : s.toCharArray()) {
			arr[c]++; // Adding the given string characters in array according to ASCII values
			queue.add(c); // Adding the character in the queue
			if (arr[c] > 1) // Identifying the repetition
			{
				while (queue.peek() != c && !queue.isEmpty()) // removing until the same character found in the queue
																// from front
				{
					arr[queue.peek()]--;
					queue.poll();
				}
				arr[queue.peek()]--;
				queue.poll();
			}
			max = Math.max(queue.size(), max); // saving max
		}
		return max;
	}
}