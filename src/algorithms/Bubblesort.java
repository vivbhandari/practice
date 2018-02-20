package algorithms;

import java.util.Arrays;

public class Bubblesort {

	public static void bubbleSort(int[] input) {

		boolean swapped = true;

		while (swapped) {
			swapped = false;
			for (int i = 1; i < input.length; i++) {
				if (input[i - 1] > input[i]) {
					int tmp = input[i];
					input[i] = input[i - 1];
					input[i - 1] = tmp;
					swapped = true;
					System.out.println(Arrays.toString(input));
				}
			}
		}
	}

	public static void main(String args[]) {
		int[] input = { 8, 3, 7, 4, 5 };
		bubbleSort(input);
		System.out.println(Arrays.toString(input));
	}
}
