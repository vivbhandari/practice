package algorithms;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

	public static List<String> getStringPermutations(String input) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < input.length(); i++) {
			permute(input, new boolean[input.length()], i, "", result);
		}
		System.out.println(result.size());
		return result;
	}

	private static void permute(String input, boolean[] used, int curPos,
			String curOutput, List<String> result) {
		used[curPos] = true;
		curOutput += input.charAt(curPos);
		if (curOutput.length() == input.length()) {
			result.add(curOutput);
		} else {
			for (int j = 0; j < input.length(); j++) {
				if (!used[j]) {
					permute(input, used, j, curOutput, result);
				}
			}
		}
		curOutput = curOutput.substring(0, curOutput.length() - 1);
		used[curPos] = false;
	}

	public static void main(String args[]) {
		System.out.println(getStringPermutations("abcd"));
	}
}
