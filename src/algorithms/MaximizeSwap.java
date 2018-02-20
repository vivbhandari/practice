package algorithms;

import java.util.Arrays;

public class MaximizeSwap {

	public static void swap(int[] input, int index1, int index2) {
		input[index1] += input[index2];
		input[index2] = input[index1] - input[index2];
		input[index1] = input[index1] - input[index2];
	}

	public static int findMaxNumberIndex(int[] input, int start, int end) {
		int maxValue = input[start];
		int index = start;
		for (int i = start; i <= end; i++) {
			if (input[i] > maxValue) {
				maxValue = input[i];
				index = i;
			}
		}
		return index;
	}

	public static void swapToMaxValue(int[] input, int swaps) {
		int start = 0;
		System.out.println(Arrays.toString(input));
		while (swaps > 0) {
			int maxIndex = findMaxNumberIndex(input, start, start + swaps);
			while (maxIndex != start) {
				swap(input, maxIndex, maxIndex - 1);
				System.out.println(Arrays.toString(input));
				--maxIndex;
				--swaps;
			}
			start += 1;
		}
	}

	public static void main(String args[]) {
		int[] input = { 2, 5, 1, 9, 3, 7, 2, 8, 9 };
		swapToMaxValue(input, 8);
	}
}
