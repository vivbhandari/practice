package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestCommonSubsequence {

	public static boolean isPrevCharSame(
			HashMap<Character, List<Integer>> bIndex, String a, int j) {
		for (int curChIndx : bIndex.get(a.charAt(j))) {
			for (int prevChIndx : bIndex.get(a.charAt(j - 1))) {
				if (curChIndx == prevChIndx + 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static String findSubSequence(String a, String b) {
		String subSequence = "";
		HashMap<Character, List<Integer>> bIndex = new HashMap<Character, List<Integer>>();
		int count = 0;

		for (int i = 0; i < b.length(); i++) {
			char ch = b.charAt(i);
			List<Integer> list = bIndex.get(ch);
			if (list == null) {
				list = new ArrayList<Integer>();
				bIndex.put(ch, list);
			}
			list.add(i);
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
				if (count != 0
						&& bIndex.get(a.charAt(j)) == bIndex.get(a
								.charAt(j - 1)) + 1) {
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
		System.out.println(findSubSequenceUniqueB("tables", "able"));
		System.out.println(findSubSequence("tables are not fun", "not fun"));
	}
}
