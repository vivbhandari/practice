package algorithms;

import java.util.Arrays;

public class MinCostPathInMatrixDynamic {

	public static int findMinCostPath(int[][] costMatrix) {
		int rows = costMatrix.length;
		int cols = costMatrix[0].length;
		int[][] resultMatrix = new int[rows][cols];
		resultMatrix[rows - 1][cols - 1] = costMatrix[rows - 1][cols - 1];

		int n = 2;
		while (n <= rows || n <= cols) {
			int curCol = Math.max(cols - n,  0);
			int curRow = Math.max(rows - n,  0);
			if (cols >= n) {
				for (int i = rows - 1; i > curRow; i--) {
					int value1 = i == rows - 1 ? Integer.MAX_VALUE
							: resultMatrix[i + 1][curCol];
					int value2 = resultMatrix[i][curCol + 1];
					resultMatrix[i][curCol] = costMatrix[i][curCol]
							+ Math.min(value1, value2);
					iterations++;
				}
			}

			if (rows >= n) {
				for (int i = cols - 1; i > curCol; i--) {
					int value1 = i == cols - 1 ? Integer.MAX_VALUE
							: resultMatrix[curRow][i + 1];
					int value2 = resultMatrix[curRow + 1][i];
					int value3 = resultMatrix[curRow + 1][i - 1];
					resultMatrix[curRow][i] = costMatrix[curRow][i]
							+ Math.min(value3, Math.min(value1, value2));
					iterations++;
				}
			}
			resultMatrix[curRow][curCol] = costMatrix[curRow][curCol]
					+ Math.min(resultMatrix[curRow + 1][curCol + 1], Math.min(
							resultMatrix[curRow + 1][curCol],
							resultMatrix[curRow][curCol + 1]));
			iterations++;
			n++;
		}

		for (int i = 0; i < resultMatrix.length; i++)
			System.out.println(Arrays.toString(resultMatrix[i]));

		return resultMatrix[0][0];
	}

	static int iterations = 0;

	public static void main(String args[]) {
		int[][] costMatrix = { { 4, 5, 6 }, 
				               { 1, 1, 3 }, 
				               { 0, 1, 2 }, };
		// int[][] costMatrix = { { 4, 5, 6 }, { 1, 1, 3 }, { 0, 1, 2 },
		// { 3, 1, 2 } };
		iterations = 0;
		System.out.println("answer=" + findMinCostPath(costMatrix));
		System.out.println("iterations=" + iterations);
	}
}
