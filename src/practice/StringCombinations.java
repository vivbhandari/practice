package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StringCombinations {

	public static void calculateCombinations(String input) {
		List<String> results = new ArrayList<String>();
		recurse(input, 0, "", results);
		System.out.println(results);
	}

	private static void recurse(String input, int start, String output,
			List<String> results) {
		for (int i = start; i < input.length(); i++) {
			output += input.charAt(i);
			results.add(output);
			if (i < input.length() - 1)
				recurse(input, i + 1, output, results);
			output = output.substring(0, output.length() - 1);
		}
	}

	public static void calculateCombinationsLex(String input) {
		Set<String> results = new TreeSet<String>();
		Set<Character> output = new TreeSet<Character>();
		recurseLex(input, 0, output, results);
		System.out.println(results);
	}

	private static void recurseLex(String input, int start,
			Set<Character> output, Set<String> results) {
		for (int i = start; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			output.add(currentChar);
			results.add(getString(output));
			if (i < input.length() - 1)
				recurseLex(input, i + 1, output, results);
			output.remove(currentChar);
		}
	}

	private static String getString(Set<Character> output) {
		String result = "";
		for (char c : output) {
			result += c;
		}
		return result;
	}

	public static void main(String[] args) {
		calculateCombinations("XWZY");
		calculateCombinationsLex("XWZY");
	}
}
