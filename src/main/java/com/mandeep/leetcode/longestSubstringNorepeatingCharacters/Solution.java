package com.mandeep.leetcode.longestSubstringNorepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public static int lengthOfLongestSubstring(String s) {

		int i = 0, j = 0, count = 0;
		Set<Character> hashSet = new HashSet<>();
		while (i < s.length()) {
			System.out.println("Char " + s.charAt(i));
			// if hash set doesn't contain the character, add it to hash set, increment i,
			// and update count;
			if (!hashSet.contains(s.charAt(i))) {
				hashSet.add(s.charAt(i));
				i++;
				count = (count > hashSet.size()) ? count : hashSet.size();
			} else {
				// remove from beginning and increment j
				hashSet.remove(s.charAt(j));
				j++;
			}
		}
		return count;

	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
		s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
		s = "dvdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
}