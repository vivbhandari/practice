package algorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] input) {

		for (int i = 0; i < input.length; i++) {
			int j = i;
			while (j > 0 && input[j - 1] > input[j]) {
				int tmp = input[j];
				input[j] = input[j - 1];
				input[j - 1] = tmp;
				j--;
			}
			System.out.println(Arrays.toString(input));
		}
	}

	public static void main(String args[]) {
		int[] input = { 8, 3, 4, 7, 5 };
		insertionSort(input);
		System.out.println(Arrays.toString(input));
	}
}
