package algorithms;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static List<List<Integer>> calculateQueenPositions(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		recurse(n, 0, new ArrayList<Integer>(), result);
		System.out.println(result.size());
		return result;
	}

	private static void recurse(int n, int row, List<Integer> positions,
			List<List<Integer>> result) {
		if (positions.size() == n) {
			result.add(new ArrayList<Integer>(positions));
		} else {
			for (int col = 0; col < n; col++) {
				if (isValid(col, row, positions)) {
					positions.add(row, col);
					recurse(n, row + 1, positions, result);
					positions.remove(row);
				}
			}
		}
	}

	private static boolean isValid(int col, int row, List<Integer> positions) {
		boolean valid = true;
		for (int i = 0; i < positions.size(); i++) {
			int existingCol = positions.get(i);
			if (existingCol == col
					|| (Math.abs(existingCol - col) == Math.abs(i - row))) {
				valid = false;
			}
		}
		return valid;
	}

	public static void main(String args[]) {
		System.out.println(calculateQueenPositions(8));
	}
}
