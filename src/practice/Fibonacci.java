package practice;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

	public static int fibonacciRecursive(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
		}
	}

	public static int fibonacciIterative(int n) {
		int prev1 = 1;
		int prev2 = 1;
		int result = 1;
		for (int i = 2; i < n; i++) {
			result = prev1 + prev2;
			prev2 = prev1;
			prev1 = result;
		}
		return result;
	}

	private static List<Integer> fibonacci;

	public static int fibonacciRecursiveWithCache(int n) {
		int result = -1;
		if (n <= fibonacci.size()) {
			result = fibonacci.get(n - 1);
		} else if (n <= 2) {
			result = 1;
			fibonacci.add(result);
			fibonacci.add(result);
		} else {
			result = fibonacciRecursiveWithCache(n - 1)
					+ fibonacciRecursiveWithCache(n - 2);
			fibonacci.add(result);
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(fibonacciRecursive(5));
		System.out.println(fibonacciIterative(5));

		fibonacci = new ArrayList<Integer>();
		System.out.println(fibonacciRecursiveWithCache(5));
		System.out.println(fibonacci);
		System.out.println(fibonacciRecursiveWithCache(8));
		System.out.println(fibonacci);
		System.out.println(fibonacciRecursiveWithCache(10));
		System.out.println(fibonacci);
	}
}
