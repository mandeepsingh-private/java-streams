package com.mandeep.leetcode.longestSubstringNorepeatingCharacters;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

class SolutionThree {
	public static int lengthOfLongestSubstring(String s) {
		int longestString = 1;
		if (s.length() == 0) {
			return longestString = 0;
		}

		int len = s.length();
		Collection<String> list = new HashSet<String>();
		for (int l = len; l > 1; l--) {
			for (int i = 0; i < len - (l - 1); i++) {
				String prevString = s.substring(i, i + l);
				list.add(prevString);
			}
		}
		System.out.println(list);
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			Boolean removeFlag = false;
			String e = it.next();
			for (int i = 0; i < e.length(); i++) {
				for (int j = i + 1; j < e.length(); j++) {
					char p = e.charAt(i);
					char c = e.charAt(j);
					if (p == c) {
						removeFlag = true;
						break;
					}
				}

			}
			if (!removeFlag & longestString < e.length()) {
				longestString = e.length();
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