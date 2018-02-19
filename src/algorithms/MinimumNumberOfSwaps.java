package algorithms;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfSwaps {

	public static int getMinimumNumOfSwaps(String s1, String s2) {
		int step = 0;
		HashSet<String> s1Derivatives = new HashSet<String>();
		s1Derivatives.add(s1);
		HashSet<String> s2Derivatives = new HashSet<String>();
		s2Derivatives.add(s2);
		HashSet<String> alreadyVisited = new HashSet<String>();
		int length = s1.length();

		while (!containsSameString(s1Derivatives, s2Derivatives)) {
			HashSet<String> toBeProcessed = step % 2 == 0 ? s1Derivatives
					: s2Derivatives;
			HashSet<String> nextLevelDerivatives = new HashSet<String>();

			for (String derivative : toBeProcessed) {
				for (int i = 0; i < length; i++) {
					for (int j = i + 1; j < length; j++) {
						if (derivative.charAt(i) != derivative.charAt(j)) {
							String newOption = swap(derivative, i, j);
							if (!alreadyVisited.contains(newOption)) {
								nextLevelDerivatives.add(newOption);
							}
						}
					}
				}
			}

			if (step % 2 == 0)
				s1Derivatives = nextLevelDerivatives;
			else
				s2Derivatives = nextLevelDerivatives;

			++step;
		}

		return step;
	}

	private static boolean containsSameString(Set<String> set1,
			Set<String> set2) {
		Set<String> tmp = new HashSet<String>(set1);
		tmp.retainAll(set2);
		return !tmp.isEmpty();
	}

	private static String swap(String input, int index1, int index2) {
		char[] chars = input.toCharArray();
		char tmp = chars[index1];
		chars[index1] = chars[index2];
		chars[index2] = tmp;
		return new String(chars);
	}

	public static void main(String args[]) {
		System.out.println(getMinimumNumOfSwaps("abc", "abc"));
		System.out.println(getMinimumNumOfSwaps("abc", "acb"));
		System.out.println(getMinimumNumOfSwaps("abc", "cab"));
		System.out.println(getMinimumNumOfSwaps("abcd", "dcba"));
		System.out.println(getMinimumNumOfSwaps("abcd", "dabc"));
	}

}
