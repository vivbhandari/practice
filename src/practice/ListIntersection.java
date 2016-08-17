package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ListIntersection {

	public static HashSet<Integer> findIntersection(List<Integer> list1,
			List<Integer> list2) {
		HashSet<Integer> result = new HashSet<Integer>();

		Collections.sort(list1);
		Collections.sort(list2);
		System.out.println(list1);
		System.out.println(list2);

		int index1 = 0;
		int index2 = 0;

		while (index1 < list1.size() && index2 < list2.size()) {
			int i = list1.get(index1);
			int j = list2.get(index2);

			if (i == j) {
				result.add(i);
			}
			if (i > j) {
				index2++;
			} else {
				index1++;
			}
		}

		return result;
	}

	public static void main(String args[]) {
		List<Integer> list1 = Arrays.asList(new Integer[] { 6, 3, 8, 4, 2, 1, 4, 0 });
		List<Integer> list2 = Arrays.asList(new Integer[] { 7, 6, 5, 4, 3, 9, 3 });

		System.out.println(findIntersection(list1, list2));
	}
}
