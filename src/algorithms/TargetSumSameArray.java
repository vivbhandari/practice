package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSumSameArray {

	public static void main(String args[]) {
		int[] A = new int[] { 1, 2, 3, 3 };
		// int[] B = new int[] { 2, 3, 3, 4 };
		// int[] C = new int[] { 1, 2, 2, 2 };
		int target = 7;
		ArrayList<Integer> intermediateSums = new ArrayList<Integer>(A.length
				* A.length);
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (j <= i)
					intermediateSums.add(null);
				else
					intermediateSums.add(A[i] + A[j]);
			}
		}

		for (int k = 0; k < A.length; k++) {
			for (int l = 0; l < intermediateSums.size(); l++) {
				if (intermediateSums.get(l) != null) {
					int two = l / A.length;
					int three = l % A.length;
					if (k != two && k != three
							&& intermediateSums.get(l) + A[k] == target) {
						List<Integer> result = Arrays.asList(new Integer[] {
								A[k], A[two], A[three] });
						results.add(result);
					}
				}
			}
		}

		System.out.println("total=" + results.size());
		System.out.println(results);
	}
}
