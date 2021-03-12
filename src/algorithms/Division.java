package algorithms;

import java.util.Arrays;

public class Division {

	public static int[] divide(int dividend, int divisor) {
		int iterations = 0; // just for test
		int sign = 1;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
			sign = -1;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int quotient = 0;
		int currentMultiplier = 1;
		int currentDivisor = divisor;

		while (dividend >= divisor) {
			iterations++;
			if (dividend >= currentDivisor) {
				dividend -= currentDivisor;
				quotient += currentMultiplier;

				currentDivisor += currentDivisor;
				currentMultiplier += currentMultiplier;
			} else {
				currentDivisor = currentDivisor >> 1;
				currentMultiplier = currentMultiplier >> 1;
			}
		}
		System.out.println("iterations=" + iterations);

		return new int[] { sign * quotient, dividend };
	}

	// Messy version but works
	public static int[] divide2(int dividend, int divisor) {
		int iterations = 0; // just for test
		int sign = 1;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
			sign = -1;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		int quotient = 1;
		int remainder = 0;

		for (int i = divisor; i < dividend && remainder < divisor; i = 2 * i) {
			iterations++;
			quotient *= 2;
			remainder = dividend - quotient * divisor;
		}
		while (remainder > divisor) {
			iterations++;
			int tmp = quotient;
			while (tmp >> 2 > 0 && remainder < divisor * tmp) {
				tmp = tmp >> 2;
				iterations++;
			}
			quotient += tmp;
			remainder = dividend - quotient * divisor;
		}
		System.out.println("iterations=" + iterations);

		return new int[] { sign * quotient, remainder };
	}

	public static int[] notgood_divide(int numerator, int denominator) {
		int sign = 1;
		if ((numerator < 0 && denominator > 0)
				|| (numerator > 0 && denominator < 0))
			sign = -1;

		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);

		int quotient = 0;
		int remainder = 0;

		while (numerator > denominator) {
			int multiple = 1;
			int sum = denominator;
			while (sum + sum < numerator) {
				sum += sum;
				multiple += multiple;
			}
			remainder = numerator - sum;
			quotient += multiple;
			numerator = remainder;
		}

		return new int[] { sign * quotient, remainder };
	}

	public static void main(String args[]) {
		System.out.println(Arrays.toString(divide(31, 6)));
		System.out.println(Arrays.toString(divide(31, 1)));
		System.out.println(Arrays.toString(divide(313, 9)));
		System.out.println(Arrays.toString(divide(-313, 9)));

		System.out.println(Arrays.toString(divide2(31, 6)));
		System.out.println(Arrays.toString(divide2(31, 1)));
		System.out.println(Arrays.toString(divide2(313, 9)));
		System.out.println(Arrays.toString(divide2(-313, 9)));
	}
}
