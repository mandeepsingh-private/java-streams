package com.mandeep.leetcode.longestSubstringNorepeatingCharacters;

class SolutionTwo {
	public static int lengthOfLongestSubstring(String s) {
		int longestString = 1;
		boolean longest = true;
		if (s.length() == 0) {
			return longestString = 0;
		}

		int len = s.length();
		// create combinations of string
		for (int l = len; l > 1; l--) {
			for (int z = 0; z < len - (l - 1); z++) {
				String e = s.substring(z, z + l);
				longest = true;
				// evaluate the size
				for (int i = 0; i < e.length(); i++) {
					for (int j = i + 1; j < e.length(); j++) {
						char p = e.charAt(i);
						char c = e.charAt(j);
						if (p == c) {
							longest = false;
							break;
						}

					}
				}

				if (longest && (longestString < e.length())) {
					longestString = e.length();
				}
			}
		}

		// System.out.println(list);
		return longestString;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
		s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}
}