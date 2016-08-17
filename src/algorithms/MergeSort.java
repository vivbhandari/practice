package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static List<Integer> mergeSort_list(List<Integer> input) {

		if (input.size() <= 1) {
			return input;
		}

		int middleIndex = input.size() / 2;
		List<Integer> list1 = mergeSort_list(input.subList(0, middleIndex));
		List<Integer> list2 = mergeSort_list(input.subList(middleIndex,
				input.size()));
		return merge_list(list1, list2);
	}

	public static List<Integer> merge_list(List<Integer> list1,
			List<Integer> list2) {

		int index1 = 0;
		int index2 = 0;
		List<Integer> merged = new ArrayList<Integer>();

		while (index1 < list1.size() && index2 < list2.size()) {
			if (list1.get(index1) < list2.get(index2)) {
				merged.add(list1.get(index1++));
			} else {
				merged.add(list2.get(index2++));
			}
		}
		while (index1 == list1.size() && index2 != list2.size()) {
			merged.add(list2.get(index2++));
		}
		while (index2 == list2.size() && index1 != list1.size()) {
			merged.add(list1.get(index1++));
		}
		return merged;
	}

	public static int[] mergeSort_arrayCopy(int[] input) {

		if (input.length <= 1) {
			return input;
		}

		int middleIndex = input.length / 2;
		int[] array1 = mergeSort_arrayCopy(Arrays.copyOfRange(input, 0,
				middleIndex));
		int[] array2 = mergeSort_arrayCopy(Arrays.copyOfRange(input,
				middleIndex, input.length));
		return merge_arrayCopy(array1, array2);
	}

	public static int[] merge_arrayCopy(int[] array1, int[] array2) {

		int index = 0;
		int start1 = 0;
		int end1 = array1.length;
		int start2 = 0;
		int end2 = array2.length;
		int count = end1 + end2;
		int[] merged = new int[count];

		while (index < count) {
			if (array1[start1] < array2[start2]) {
				merged[index++] = array1[start1++];
			} else {
				merged[index++] = array2[start2++];
			}

			while (start1 == end1 && start2 != end2) {
				merged[index++] = array2[start2++];
			}

			while (start2 == end2 && start1 != end1) {
				merged[index++] = array1[start1++];
			}
		}
		return merged;
	}

	public static void mergeSort_arrayInPlace(int[] input, int start, int end) {

		if (end <= start) {
			return;
		}

		int middleIndex = start + (end - start) / 2;
		mergeSort_arrayInPlace(input, start, middleIndex);
		mergeSort_arrayInPlace(input, middleIndex + 1, end);
		merge_arrayInPlace(input, start, middleIndex, middleIndex + 1, end);
	}

	public static void merge_arrayInPlace(int[] input, int start1, int end1,
			int start2, int end2) {

		int count = end1 - start1 + end2 - start2 + 2;
		int[] merged = new int[count];
		int index = 0;

		while (index < count) {
			if (input[start1] < input[start2]) {
				merged[index++] = input[start1++];
			} else {
				merged[index++] = input[start2++];
			}

			while (start1 > end1 && start2 <= end2) {
				merged[index++] = input[start2++];
			}

			while (start2 > end2 && start1 <= end1) {
				merged[index++] = input[start1++];
			}
		}
		for (int i = count - 1; i >= 0; i--) {
			input[end2--] = merged[i];
		}
	}

	public static void main(String args[]) {
		int[] input = new int[] { 4, 2, 6, 3, 5, 7, 1, 8 };
		mergeSort_arrayInPlace(input, 0, input.length - 1);
		System.out.println("result=" + Arrays.toString(input));

		input = new int[] { 4, 2, 6, 3, 5, 7, 1, 8 };
		input = mergeSort_arrayCopy(input);
		System.out.println("result=" + Arrays.toString(input));

		System.out.println("result="
				+ mergeSort_list(Arrays.asList(new Integer[] { 4, 2, 6, 3, 5,
						7, 1, 8 })));
	}
}
