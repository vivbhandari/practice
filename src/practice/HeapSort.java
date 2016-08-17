package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSort {

	public static List<Integer> heapSort(List<Integer> input) {
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

	public static void main(String args[]) {
		List<Integer> input = Arrays.asList(new Integer[] { 4, 2, 7, 5, 9, 6,
				3, 1 });
		System.out.println(heapSort(input));
	}
}
