package com.mandeep.streams.ArrayPairs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {
	public static void main(String[] args) {
		List<Integer> nums1 = Arrays.asList(1, 2, 3);
		List<Integer> nums2 = Arrays.asList(3, 4);
		List<int[]> pairs = nums1.stream().flatMap(e -> {
			return nums2.stream().map(ele -> new int[] { e, ele });
		}).collect(Collectors.toList());
		pairs.stream().forEach(i -> System.out.println(i[0] + "," + i[1]));
	}
}
