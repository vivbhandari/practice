package practice;

import java.util.Arrays;
import java.util.HashSet;

public class WordBreakDynamic {

	public static boolean wordBreak(String input, HashSet<String> dictionary) {
		boolean[] wb = new boolean[input.length()];

		if (input.length() == 0) {
			return false;
		}

		for (int i = 0; i < input.length(); i++) {
			System.out.println("i=" + i);
			System.out.println("wb=" + Arrays.toString(wb));

			if (wb[i] == false
					&& dictionary.contains(input.substring(0, i + 1))) {
				wb[i] = true;
			}

			if (wb[i] == true) {

				for (int j = i + 1; j < input.length(); j++) {
					System.out.println("wb=" + Arrays.toString(wb));

					if (wb[j] == false
							&& dictionary.contains(input
									.substring(i + 1, j + 1))) {
						wb[j] = true;
					}

					if (wb[j] == true && j == input.length() - 1) {
						System.out.println("wb=" + Arrays.toString(wb));
						StringBuffer b = new StringBuffer(input);
						int padding = 0;
						for (int k = 0; k < wb.length - 1; k++) {
							if (wb[k] == true) {
								b.insert(k + 1 + padding++, " ");
							}
						}
						System.out.println(b);
						return true;
					}
				}
			}
		}

		return false;
	}

	public static int wordBreakCount(String input, HashSet<String> dictionary) {
		boolean[] wb = new boolean[input.length()];
		int count = 0;

		if (input.length() == 0) {
			return count;
		}

		for (int i = 0; i < input.length(); i++) {
			System.out.println("i=" + i);
			System.out.println("wb=" + Arrays.toString(wb));

			if (dictionary.contains(input.substring(0, i + 1))) {
				wb[i] = true;
				if (i == input.length() - 1) {
					System.out.println(input);
					++count;
				}
			}

			if (wb[i] == true) {

				for (int j = i + 1; j < input.length(); j++) {
					System.out.println("wb=" + Arrays.toString(wb));

					if (wb[j] == false
							&& dictionary.contains(input
									.substring(i + 1, j + 1))) {
						wb[j] = true;
					}

					if (wb[j] == true && j == input.length() - 1) {
						System.out.println("wb=" + Arrays.toString(wb));
						StringBuffer b = new StringBuffer(input);
						int padding = 0;
						for (int k = 0; k < wb.length - 1; k++) {
							if (wb[k] == true && k < i + 1) {
								b.insert(k + 1 + padding++, " ");
							}
						}
						System.out.println(b);
						++count;
						System.out.println(count);
					}
				}
			}
		}

		return count;
	}

	public static void main(String args[]) {
		HashSet<String> dictionary = new HashSet<String>(
				Arrays.asList(new String[] { "i", "like", "samsung", "sam",
						"sung" }));
		System.out.println(dictionary);
		boolean result = wordBreak("ilikesamsung", dictionary);
		System.out.println(result);
//		int count = wordBreakCount("ilikesamsung", dictionary);
//		System.out.println(count);
	}
}
