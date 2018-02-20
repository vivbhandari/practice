package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxConsecutiveIntegers {

	public static int findMaxConsecutiveIntegers_hash(int[] input) {
		int count = 0;
		Set<Integer> inputSet = new HashSet<Integer>();
		for (int i : input) {
			inputSet.add(i);
		}
		for (int i : inputSet) {
			int curCount = 1;
			if (!inputSet.contains(i - 1)) {
				while (inputSet.contains(++i)) {
					curCount++;
				}
				if (curCount > count) {
					count = curCount;
				}
			}
		}

		return count;
	}

	public static int findMaxConsecutiveIntegers(int[] input) {
		int count = 0;

		Arrays.sort(input);
		int curCount = 0;
		int prev = Integer.MIN_VALUE;
		for (int i : input) {
			if (curCount != 0 && prev == i - 1) {
				curCount++;
			} else {
				curCount = 1;
			}
			prev = i;
			if (curCount > count) {
				count = curCount;
			}
		}

		return count;
	}

	public static void main(String args[]) {
		int[] input = new int[] { 92, 101, 2, 93, 94, 99, 95, 90 };
		System.out.println(findMaxConsecutiveIntegers_hash(input));
		System.out.println(findMaxConsecutiveIntegers(input));
	}
}
