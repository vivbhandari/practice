package algorithms;

import java.util.HashMap;
import java.util.Stack;

public class IntegerInWords {
	HashMap<Integer, String> numMap = new HashMap<Integer, String>();
	HashMap<Integer, String> suffixMap = new HashMap<Integer, String>();

	public IntegerInWords() {
		numMap.put(0, "zero");
		numMap.put(1, "one");
		numMap.put(2, "two");
		numMap.put(3, "three");
		numMap.put(4, "four");
		numMap.put(5, "five");
		numMap.put(6, "six");
		numMap.put(7, "seven");
		numMap.put(8, "eight");
		numMap.put(9, "nine");
		numMap.put(10, "ten");
		numMap.put(11, "eleven");
		numMap.put(12, "twelve");
		numMap.put(13, "thirteen");
		numMap.put(14, "fourteen");
		numMap.put(15, "fifteen");
		numMap.put(16, "sixteen");
		numMap.put(17, "seventeen");
		numMap.put(18, "eighteen");
		numMap.put(19, "nineteen");
		numMap.put(20, "twenty");
		numMap.put(30, "thirty");
		numMap.put(40, "forty");
		numMap.put(50, "fifty");
		numMap.put(60, "sixty");
		numMap.put(70, "seventy");
		numMap.put(80, "eighty");
		numMap.put(90, "ninety");

		suffixMap.put(3, "hundred");
		suffixMap.put(4, "thousand");
		suffixMap.put(6, "hundred");
		suffixMap.put(7, "million");
	}

	public String convert(int number) {
		String numberStr = "";
		Stack<String> words = new Stack<String>();
		int position = 1;
		int prevDigit = -1;

		do {
			int rem = number % 10;

			if ((position - 2) % 3 == 0) {
				rem = rem * 10;
				if (rem == 10 || rem == 0) {
					words.pop();
					rem += prevDigit;
				}
			}

			if (suffixMap.containsKey(position)) {
				if (rem != 0 || position != 3)
					words.push(suffixMap.get(position));
			}

			if (rem != 0 || (position - 1) % 3 == 0)
				words.push(numMap.get(rem));

			number = number / 10;
			position++;
			prevDigit = rem;
		} while (number > 0);

		for (String word : words) {
			numberStr = word + " " + numberStr;
		}
		return numberStr;
	}

	public static void main(String args[]) {
		IntegerInWords integerInWords = new IntegerInWords();
		System.out.println(integerInWords.convert(0));
		System.out.println(integerInWords.convert(5));
		System.out.println(integerInWords.convert(10));
		System.out.println(integerInWords.convert(17));
		System.out.println(integerInWords.convert(28));
		System.out.println(integerInWords.convert(99));
		System.out.println(integerInWords.convert(100));
		System.out.println(integerInWords.convert(101));
		System.out.println(integerInWords.convert(135));
		System.out.println(integerInWords.convert(276));
		System.out.println(integerInWords.convert(999));
		System.out.println(integerInWords.convert(1000));
		System.out.println(integerInWords.convert(1015));
		System.out.println(integerInWords.convert(1236));
		System.out.println(integerInWords.convert(9999));
		System.out.println(integerInWords.convert(10000));
		System.out.println(integerInWords.convert(10199));
		System.out.println(integerInWords.convert(12345));
		System.out.println(integerInWords.convert(27345));
		System.out.println(integerInWords.convert(99999));
		System.out.println(integerInWords.convert(100000));
		System.out.println(integerInWords.convert(100123));
		System.out.println(integerInWords.convert(102323));
		System.out.println(integerInWords.convert(113323));
		System.out.println(integerInWords.convert(134323));
		System.out.println(integerInWords.convert(999999));
//		System.out.println(integerInWords.convert(1000000));
		System.out.println(integerInWords.convert(1211133));
		System.out.println(integerInWords.convert(9999999));
		System.out.println(integerInWords.convert(10999999));
		System.out.println(integerInWords.convert(13109999));
		System.out.println(integerInWords.convert(35101000));
		System.out.println(integerInWords.convert(99999999));
	}
}
