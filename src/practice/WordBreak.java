package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

	public static boolean wordBreak(String input, HashSet<String> dictionary,
			List<String> output) {
		if (input.length() == 0) {
			return true;
		}

		for (int i = 1; i <= input.length(); i++) {
			String currentWord = input.substring(0, i);
			if (dictionary.contains(currentWord)
					&& wordBreak(input.substring(i), dictionary, output)) {
				output.add(0, currentWord);
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		HashSet<String> dictionary = new HashSet<String>(
				Arrays.asList(new String[] { "i", "like", "samsung", "sam",
						"sung" }));
		System.out.println(dictionary);
		List<String> output = new ArrayList<String>();
		boolean result = wordBreak("ilikesamsung", dictionary, output);
		System.out.println(result);
		System.out.println(output);
	}
}
