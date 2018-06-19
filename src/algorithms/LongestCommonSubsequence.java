package algorithms;

import java.util.HashMap;
import java.util.HashSet;

public class LongestCommonSubsequence {

	public static boolean isPrevCharSame(HashMap<Character, HashSet<Integer>> bIndex, String a,
			int j) {
		HashSet<Integer> curCharIndices = bIndex.get(a.charAt(j));
		for (int prevCharIndx : bIndex.get(a.charAt(j - 1))) {
			if (curCharIndices.contains(prevCharIndx + 1))
				return true;
		}

		return false;
	}

	public static String findSubSequence(String a, String b) {
		String subSequence = "";
		HashMap<Character, HashSet<Integer>> bIndex = new HashMap<Character, HashSet<Integer>>();
		int count = 0;

		for (int i = 0; i < b.length(); i++) {
			char ch = b.charAt(i);
			HashSet<Integer> set = bIndex.get(ch);
			if (set == null) {
				set = new HashSet<Integer>();
				bIndex.put(ch, set);
			}
			set.add(i);
		}
		System.out.println("bIndex=" + bIndex);

		for (int j = 0; j < a.length(); j++) {
			if (bIndex.containsKey(a.charAt(j))) {
				if (count != 0 && isPrevCharSame(bIndex, a, j)) {
					++count;
				} else {
					count = 1;
				}
				if (subSequence.length() < count) {
					subSequence = a.substring(j - count + 1, j + 1);
				}
			} else {
				count = 0;
			}
		}

		return subSequence;
	}

	public static String findSubSequenceUniqueB(String a, String b) {
		String subSequence = "";
		HashMap<Character, Integer> bIndex = new HashMap<Character, Integer>();
		int count = 0;

		for (int i = 0; i < b.length(); i++) {
			bIndex.put(b.charAt(i), i);
		}

		for (int j = 0; j < a.length(); j++) {
			if (bIndex.containsKey(a.charAt(j))) {
				if (count != 0 && bIndex.get(a.charAt(j)) == bIndex.get(a.charAt(j - 1)) + 1) {
					++count;
				} else {
					count = 1;
				}
				if (subSequence.length() < count) {
					subSequence = a.substring(j - count + 1, j + 1);
				}
			} else {
				count = 0;
			}
		}

		return subSequence;
	}

	public static void main(String args[]) {
		System.out.println(findSubSequenceUniqueB("tables", "able x"));
		System.out.println(findSubSequence("tables are not fun", "not fun"));
	}
}
