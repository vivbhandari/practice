package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MinCostPathInMatrix {

	static class Cell {
		int row;
		int col;

		public Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (col != other.col || row != other.row)
				return false;
			return true;
		}

		public String toString() {
			return "Cell [row=" + row + ", col=" + col + "]";
		}
	}

	public static int getCost(int[][] matrix, List<Cell> path) {
		int cost = 0;
		for (Cell cell : path)
			cost += matrix[cell.row][cell.col];
		return cost;
	}

	public static int findLeastCost(int[][] matrix, Cell currentCell,
			Cell endCell, List<Cell> pathSoFar, int minCost, List<Cell> result) {
		pathSoFar.add(currentCell);
		iterations++;
		if (currentCell.equals(endCell)) {
			int newMinCost = getCost(matrix, pathSoFar);
			if (newMinCost < minCost) {
				result.clear();
				result.addAll(pathSoFar);
				minCost = newMinCost;
			}
		} else {
			int rowEnd = Math.min(matrix.length - 1, currentCell.row + 1);
			int colEnd = Math.min(matrix[0].length - 1, currentCell.col + 1);

			for (int i = currentCell.row; i <= rowEnd; i++) {
				for (int j = currentCell.col; j <= colEnd; j++) {
					Cell neighborCell = new Cell(i, j);
					if (!pathSoFar.contains(neighborCell)) {
						minCost = findLeastCost(matrix, neighborCell, endCell,
								pathSoFar, minCost, result);
					}
				}
			}
		}
		pathSoFar.remove(currentCell);
		return minCost;
	}

	public static int findLeastcost(int matrix[][]) {
		List<Cell> result = new ArrayList<MinCostPathInMatrix.Cell>();
		int minCost = findLeastCost(matrix, new Cell(0, 0), new Cell(
				matrix.length - 1, matrix[0].length - 1),
				new ArrayList<MinCostPathInMatrix.Cell>(), Integer.MAX_VALUE,
				result);
		System.out.println(result);
		return minCost;
	}

	static int iterations = 0;

	public static int findMinCostSimpler(int[][] costMatrix, int row, int col) {
		iterations++;
		if (row == costMatrix.length - 1 && col == costMatrix[0].length - 1) {
			return costMatrix[row][col];
		}

		int value1 = row < costMatrix.length - 1 ? findMinCostSimpler(
				costMatrix, row + 1, col) : Integer.MAX_VALUE;
		int value2 = col < costMatrix[0].length - 1 ? findMinCostSimpler(
				costMatrix, row, col + 1) : Integer.MAX_VALUE;
		int value3 = row < costMatrix.length - 1
				&& col < costMatrix[0].length - 1 ? findMinCostSimpler(
				costMatrix, row + 1, col + 1) : Integer.MAX_VALUE;

		return costMatrix[row][col]
				+ Math.min(value1, Math.min(value2, value3));
	}

	public static void main(String args[]) {
		int[][] costMatrix = { { 4, 5, 6 }, { 1, 1, 3 }, { 0, 1, 2 } };
		iterations = 0;
		System.out.println("answer=" + findLeastcost(costMatrix));
		System.out.println("iterations=" + iterations);
		iterations = 0;
		System.out.println("answer=" + findMinCostSimpler(costMatrix, 0, 0));
		System.out.println("iterations=" + iterations);
	}
}
