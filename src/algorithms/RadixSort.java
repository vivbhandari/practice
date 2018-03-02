package algorithms;

import java.util.Arrays;

public class RadixSort {

	private static int getMax(int[] input) {
		int max = Integer.MIN_VALUE;

		for (int i : input) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	private static int[] countSort(int[] input, int exp) {
		int[] output = new int[input.length];
		int[] count = new int[10];
		Arrays.fill(count, 0);

		for (int i = 0; i < input.length; i++) {
			count[(input[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = input.length -1; i >=0; i--) {
			output[--count[(input[i] / exp) % 10]] = input[i];
		}

		return output;
	}

	public static int[] radixSort(int[] input) {
		int max = getMax(input);

		for (int exp = 1; max / exp > 0; exp *= 10) {
			input = countSort(input, exp);
		}

		return input;
	}

	public static void main(String args[]) {
		System.out.println(Arrays.toString(radixSort(new int[] { 3, 9, 19, 11,
				5, 9, 3, 3, 1, 13, 133, 101, 99, 101, 13 })));
	}
}
