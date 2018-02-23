package algorithms;

import java.util.Arrays;

public class QuickSort {

	private static void swap(int[] input, int index1, int index2) {
		int tmp = input[index1];
		input[index1] = input[index2];
		input[index2] = tmp;
	}

	public static void quickSortRecurse(int[] input, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivotIndex = start + (end - start) / 2;
		System.out.println("pivotIndex=" + pivotIndex);

		int index1 = start;
		int index2 = pivotIndex + 1;

		while (index1 < pivotIndex || index2 <= end) {

			while (index1 < pivotIndex && input[index1] < input[pivotIndex])
				index1++;

			while (index2 <= end && input[index2] > input[pivotIndex])
				index2++;

			if (index1 < pivotIndex && index2 <= end) {
				swap(input, index1++, index2++);
			} else if (index1 == pivotIndex && index2 <= end) {
				swap(input, pivotIndex + 1, index2++);
				swap(input, pivotIndex, pivotIndex + 1);
				pivotIndex++;
				index1++;
			} else if (index1 < pivotIndex && index2 > end) {
				swap(input, pivotIndex - 1, index1++);
				swap(input, pivotIndex, pivotIndex - 1);
				pivotIndex--;
			}
			System.out.println(Arrays.toString(input));
		}
		quickSortRecurse(input, start, pivotIndex - 1);
		quickSortRecurse(input, pivotIndex + 1, end);
	}

	public static void quickSort(int[] input) {
		// quickSortRecurse(input, 0, input.length - 1);
		quickSortRecurse2(input, 0, input.length - 1);
	}

	// this is simpler
	public static void quickSortRecurse2(int[] input, int start, int end) {

		if (start >= end) {
			return;
		}

		int pivotIndex = start + (end - start) / 2;
		System.out.println("pivotIndex=" + pivotIndex);

		int index1 = start;
		int index2 = end;

		while (index1 < index2) {

			while (input[index1] < input[pivotIndex])
				index1++;

			while (input[index2] > input[pivotIndex])
				index2--;

			if (index1 < index2) {
				swap(input, index1, index2);
			}

			index1++;
			index2--;
			System.out.println(Arrays.toString(input));
		}
		quickSortRecurse2(input, start, index2);
		quickSortRecurse2(input, index1, end);
	}

	public static void main(String args[]) {
		int[] input = new int[] { 7, 6, 2, 8, 5, 0, 4, 1, 3 };
		System.out.println(Arrays.toString(input));
		quickSort(input);
		// System.out.println(Arrays.toString(input));
	}
}
