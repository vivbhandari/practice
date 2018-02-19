package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SmallerNumbersWithOnesZeros {

	public static List<Integer> getNumbers(int input) {
		List<Integer> numbers = new ArrayList<Integer>();
		int index = 0;

		if (input > 0) {
			numbers.add(0);
		}

		if (input > 1) {
			numbers.add(1);
			while (++index < numbers.size()) {
				int number = numbers.get(index);
				int next1 = number * 10;
				if (next1 < input)
					numbers.add(next1);
				int next2 = next1 + 1;
				if (next2 < input)
					numbers.add(next2);
			}
		}
		return numbers;
	}

	public static void main(String args[]) {
		System.out.println(getNumbers(0));
		System.out.println(getNumbers(-1));
		System.out.println(getNumbers(1));
		System.out.println(getNumbers(2));
		System.out.println(getNumbers(123));
		System.out.println(getNumbers(1234));
	}
}
