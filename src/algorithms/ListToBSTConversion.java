package algorithms;

import java.util.Arrays;
import java.util.List;

public class ListToBSTConversion {

	public static int[] convert(List<Integer> sortedList) {
		int[] tree = new int[sortedList.size()];
		recurse(sortedList, tree, 0, sortedList.size(), 0);
		return tree;
	}

	private static void recurse(List<Integer> sortedList, int[] tree, int start,
			int end, int nextPosition) {
		if (nextPosition < sortedList.size()) {
			int middle = (start + end) / 2;
			tree[nextPosition] = sortedList.get(middle);
			recurse(sortedList, tree, start, middle, 2 * nextPosition + 1);
			recurse(sortedList, tree, middle, end, 2 * nextPosition + 2);
		}
	}

	public static void main(String args[]) {
		List<Integer> sortedList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5,
				6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		System.out.println(Arrays.toString(convert(sortedList)));
	}
}
