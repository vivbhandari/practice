package algorithms;

import java.util.Arrays;

public class CountingSort {

	int maxNum;

	public CountingSort(int maxNum) {
		this.maxNum = maxNum;
	}

	public int[] sort(int[] input) {
		int[] output = new int[input.length];
		int[] count = new int[maxNum];
		Arrays.fill(count, 0);

		for (int i = 0; i < input.length; i++) {
			count[input[i]]++;
		}

		for (int i = 1; i < maxNum; i++) {
			count[i] += count[i - 1];
		}

		for (int i = 0; i < input.length; i++) {
			output[--count[input[i]]] = input[i];
		}

		return output;
	}

	public static void main(String args[]) {
		CountingSort cs = new CountingSort(20);
		System.out.println(Arrays.toString(cs.sort(new int[] { 3, 9, 19, 11, 5,
				9, 3, 3, 1, 13 })));
	}
}
