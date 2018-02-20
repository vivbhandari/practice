package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StickPieces {

	class Result {
		int cost = Integer.MAX_VALUE;
		List<Integer> order = null;

		@Override
		public String toString() {
			return "Result [cost=" + cost + ", order=" + order + "]";
		}
	}

	public void findMinCost(int stickLength, List<Integer> indices) {
		Result result = new Result();
		for (int i = 0; i < indices.size(); i++) {
			recurse(stickLength, indices, i, new boolean[indices.size()],
					new ArrayList<Integer>(), result);
		}
		System.out.println(result);
	}

	private void recurse(int stickLength, List<Integer> indices, int curIndex,
			boolean used[], List<Integer> curOrder, Result result) {
		used[curIndex] = true;
		curOrder.add(indices.get(curIndex));
		if (curOrder.size() == indices.size()) {
			int cost = getCost(stickLength, curOrder);
			System.out.println("cost=" + cost);
			if (cost < result.cost) {
				result.cost = cost;
				result.order = new ArrayList<Integer>(curOrder);
			}
		} else {
			for (int i = 0; i < indices.size(); i++) {
				if (used[i] == false) {
					recurse(stickLength, indices, i, used, curOrder, result);
				}
			}
		}
		used[curIndex] = false;
		curOrder.remove(curOrder.size() - 1);
	}

	int getCost(int stickLength, List<Integer> order) {
		int cost = stickLength;
		List<Integer> pieces = new ArrayList<Integer>();
		for (int index : order) {
			if (pieces.isEmpty()) {
				pieces.add(index);
				pieces.add(stickLength - index);
			} else {
				int lenSoFar = 0;
				for (int pIdx = 0; pIdx < pieces.size(); pIdx++) {
					lenSoFar += pieces.get(pIdx);
					if (lenSoFar > index) {
						int size = pieces.remove(pIdx);
						cost += size;
						pieces.add(pIdx, size - (lenSoFar - index));
						pieces.add(pIdx + 1, lenSoFar - index);
						break;
					}
				}
			}
		}
		return cost;
	}

	public static void main(String args[]) {
		StickPieces sp = new StickPieces();

		sp.findMinCost(10, Arrays.asList(new Integer[] { 2, 4, 7 }));
		// 10 (4,6) + 4(2,2) + 6(3,3)

		sp.findMinCost(20, Arrays.asList(new Integer[] { 2, 4, 7, 12 }));
		// 20 (12,8) + 12(7,5) + 7(4,3) + 4(2,2)
	}
}
