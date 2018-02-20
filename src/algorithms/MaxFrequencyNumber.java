package algorithms;

import java.util.Arrays;

public class MaxFrequencyNumber {

	public static int findMaxIndex(int[] input) {
		int maxIndex = 0;
		int maxValue = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] > maxValue) {
				maxValue = input[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public static void findGreatestNumber(int[] input) {
		int k = input[findMaxIndex(input)] + 1;
		if (k > input.length) {
			throw new IllegalArgumentException("Invalid input");
		}
		System.out.println("k=" + k);
		for (int i = 0; i < input.length; i++) {
			input[input[i] % k] += k;
		}
		System.out.println("input=" + Arrays.toString(input));
		int maxFreqIndex = findMaxIndex(input);
		int frequency = input[maxFreqIndex] / k;
		for (int i = 0; i < input.length; i++) {
			input[i] = input[i] % k;
		}
		System.out.println("input=" + Arrays.toString(input));

		System.out.println(maxFreqIndex + ":" + frequency);

	}

	public static void main(String args[]) {
		int input[] = { 1, 2, 1, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 11 };
		findGreatestNumber(input);
	}
}
