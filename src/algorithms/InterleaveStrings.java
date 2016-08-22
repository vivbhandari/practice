package algorithms;

import java.util.ArrayList;
import java.util.List;

public class InterleaveStrings {

	public static List<String> getInterleaveStrings(String str1, String str2) {
		List<String> result = new ArrayList<String>();
		getInterleaveStrings(str1, str2, 0, 0, "", result);
		System.out.println(result.size());
		return result;
	}

	public static void getInterleaveStrings(String str1, String str2,
			int index1, int index2, String outputSoFar, List<String> result) {
		if (index1 == str1.length() && index2 == str2.length()) {
			result.add(outputSoFar);
		}

		if (index1 < str1.length()) {
			outputSoFar += str1.charAt(index1);
			getInterleaveStrings(str1, str2, index1 + 1, index2, outputSoFar,
					result);
			outputSoFar = outputSoFar.substring(0, outputSoFar.length() - 1);
		}

		if (index2 < str2.length()) {
			outputSoFar += str2.charAt(index2);
			getInterleaveStrings(str1, str2, index1, index2 + 1, outputSoFar,
					result);
			outputSoFar = outputSoFar.substring(0, outputSoFar.length() - 1);
		}
	}

	public static void main(String args[]) {
		System.out.println(getInterleaveStrings("abc", "de"));
	}
}
