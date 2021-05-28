package com.mandeep.codingGame.theDescent;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * The while loop represents the game. Each iteration represents a turn of the
 * game where you are given inputs (the heights of the mountains) and where you
 * have to print an output (the index of the mountain to fire on) The inputs you
 * are given are automatically updated according to your last actions.
 **/
class Player {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		List<Integer> l = new ArrayList<>();
		// game loop
		while (true) {
			for (int i = 0; i < 8; i++) {
				int mountainH = in.nextInt(); // represents the height of one
												// mountain.

				l.add(mountainH);

			}

			OptionalInt elem = l.stream().mapToInt(e -> e).distinct().max();
			for (int i = 0; i < l.size(); i++) {
				if (elem.getAsInt() == l.get(i)) {
					System.out.println("IDX " + i);
					l.removeAll(l);
				}
			}

		}
	}
}