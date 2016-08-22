package algorithms;

public class MaximallyClose {

	public static void findMaxmallyClose(int number) {
		int factorDiff = number;
		int multipleDiff = number;
		int factor1 = 0;
		int factor2 = 0;
		for (int i = 2; i < number / 2; i++) {
			int tmpFactor1 = i;
			int j = 0;
			while (j <= 1) {
				int tmpFactor2 = number / i + j;
				int multiple = tmpFactor1 * tmpFactor2;
				int tmpMultiplediff = Math.abs(multiple - number);
				int tmpFactorDiff = Math.abs(tmpFactor1 - tmpFactor2);
				if (tmpMultiplediff <= multipleDiff
						&& tmpFactorDiff <= factorDiff) {
					multipleDiff = tmpMultiplediff;
					factorDiff = tmpFactorDiff;
					factor1 = tmpFactor1;
					factor2 = tmpFactor2;
				}
				j++;
			}
		}
		System.out.println(number + " = " + factor1 + ", " + factor2);
	}

	public static void main(String args[]) {
		for (int i = 7; i < 22; i++) {
			findMaxmallyClose(i);
		}
	}
}
