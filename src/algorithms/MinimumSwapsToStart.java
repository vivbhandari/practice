package algorithms;

import java.util.HashSet;
import java.util.Set;

/*** not working as expected as of now  ***/
public class MinimumSwapsToStart {

	public static int calculate(String src, String dst) {
		return recursive(src, dst, new HashSet<String>(), Integer.MAX_VALUE, 0);
	}

	private static int recursive(String src, String dst, Set<String> visited,
			int minStep, int step) {
		if (src.equals(dst)) {
			if (step < minStep) {
				minStep = step;
			}
		} else {
			visited.add(src);
			for (int i = src.length() - 1; i >= 0; i--) {
				String newSrc = swap(src, i);
//				if (!visited.contains(newSrc)) {
					minStep = Math.min(minStep,
							recursive(newSrc, dst, visited, minStep, step + 1));
//				}
			}
		}
		return minStep;
	}

	private static String swap(String src, int index) {
		StringBuilder builder = new StringBuilder(src);
		char ch = builder.charAt(index);
		builder.deleteCharAt(index);
		builder.insert(0, ch);
		return builder.toString();
	}

	public static void main(String args[]) {
		 System.out.println(calculate("abc", "abc"));
		 System.out.println(calculate("abc", "cba"));
		 System.out.println(calculate("abc", "acb"));
		System.out.println(calculate("abcd", "abdc"));// cabd, dcab, bdca, abdc
	}
}
