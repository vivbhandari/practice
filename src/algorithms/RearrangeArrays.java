package algorithms;

import java.util.Arrays;

public class RearrangeArrays {

	public static void rearrange(String[] input, int partitionIndex) {
		int numberOfSwaps = 1;

		while (numberOfSwaps < partitionIndex) {
			int bIndex = partitionIndex;
			for (int i = numberOfSwaps; i < partitionIndex; i += (2
					* numberOfSwaps)) {
				for (int j = 0; j < numberOfSwaps; j++) {
					String tmp = input[i + j];
					input[i + j] = input[bIndex + j];
					input[bIndex + j] = tmp;
				}
				bIndex += (2 * numberOfSwaps);
			}
			numberOfSwaps *= 2;
		}
		System.out.println(Arrays.toString(input));
	}

	private static String[] getInput(int count) {
		String[] input = new String[2 * count];
		for (int i = 0; i < count; i++) {
			input[i] = "a" + i;
			input[i + count] = "b" + i;
		}
		return input;
	}

	public static void main(String args[]) {
		int count = 8;
		String[] input = getInput(count);
		System.out.println(Arrays.toString(input));
		rearrange(input, count);
	}
}
