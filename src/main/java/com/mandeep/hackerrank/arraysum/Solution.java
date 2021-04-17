package com.mandeep.hackerrank.arraysum;

import java.io.IOException;
import java.util.Arrays;

public class Solution {

	/*
	 * Complete the simpleArraySum function below.
	 */
	static int simpleArraySum(int[] ar) {
		/*
		 * Write your code here.
		 */
		int sum = Arrays.stream(ar).sum();

		return sum;
	}

	public static void main(String[] args) throws IOException {

		int[] arItems = { 1, 2, 3, 4, 10, 11 };

		int result = simpleArraySum(arItems);
		System.out.println(result);

	}
}
