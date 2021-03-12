package algorithms;

public class LargestSumContigous {

	public static int getLargestSumContiguous(int[] input) {
		int maxSum = 0;
		int currentSum = 0;

		for (int i : input) {
			currentSum = Math.max(0, currentSum += i);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

	public static void main(String args[]) {
		int[] input = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(getLargestSumContiguous(input));
	}
}
