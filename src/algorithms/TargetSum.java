package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetSum {

	public static void main(String args[]) {
		int[] A = new int[] { 1, 2, 3, 3 };
		int[] B = new int[] { 2, 3, 3, 4 };
		int[] C = new int[] { 1, 2, 2, 2 };
		int target = 7;
		ArrayList<Integer> intermediateSums = new ArrayList<Integer>(B.length
				+ C.length);
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();

		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < C.length; j++) {
				intermediateSums.add(B[i] + C[j]);
			}
		}

		for (int k = 0; k < A.length; k++) {
			for (int l = 0; l < intermediateSums.size(); l++) {
				if (intermediateSums.get(l) + A[k] == target) {
					List<Integer> result = Arrays.asList(new Integer[] { A[k],
							B[l / C.length], C[l % C.length] });
					results.add(result);
				}
			}
		}

		System.out.println("total=" + results.size());
		System.out.println(results);
	}
}
