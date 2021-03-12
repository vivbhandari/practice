package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {

	public static List<Integer> heapSortWithPQ(List<Integer> input) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o2 - o1;
					}
				});
		heap.addAll(input);
		List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < input.size(); i++) {
			System.out.println(heap);
			output.add(heap.poll());
		}
		return output;
	}

	public static List<Integer> heapSort(List<Integer> input) {

		int size = input.size();

		System.out.println(input);

		System.out.println("-----");

		for (int i = size/2 -1 ; i >= 0; i--) {
			heapify(input, size, i);
			System.out.println(input);
		}

		System.out.println("-----");

		for (int i = size - 1; i >= 0; i--) {
			swap(input, 0, i);
			heapify(input, i, 0);
			System.out.println(input);
		}

		return input;
	}

	private static void swap(List<Integer> input, int index1, int index2) {
		int tmp = input.get(index1);
		input.set(index1, input.get(index2));
		input.set(index2, tmp);
	}

	private static void heapify(List<Integer> input, int size, int root) {
		int largest = root;
		int leftChild = 2 * root + 1;
		int rightChild = 2 * root + 2;

		if (leftChild < size && input.get(leftChild) > input.get(largest)) {
			largest = leftChild;
		}

		if (rightChild < size && input.get(rightChild) > input.get(largest)) {
			largest = rightChild;
		}

		if (largest != root) {
			swap(input, root, largest);
			heapify(input, size, largest);
		}
	}

	public static void main(String args[]) {
		List<Integer> input = Arrays
				.asList(new Integer[] { 12, 11, 13, 5, 6, 7, 50, 44, 22 });
		// System.out.println(heapSortWithPQ(input));
		System.out.println(heapSort(input));
	}
}
