package algorithms;

import java.util.HashMap;

public class OrderingString {

	public static boolean isOrderTrue(String input, String orderStr) {
		boolean valid = true;
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			charMap.put(input.charAt(i), i);
		}

		for (int j = 1; j < orderStr.length(); j++) {
			char ch1 = orderStr.charAt(j - 1);
			char ch2 = orderStr.charAt(j);

			if (!charMap.containsKey(ch1) || !charMap.containsKey(ch2)
					|| charMap.get(ch1) > charMap.get(ch2)) {
				valid = false;
				break;
			}
		}

		return valid;
	}

	public static boolean isOrderTrueNoSpace(String input, String orderStr) {
		boolean valid = true;
		for (int j = 1; j < orderStr.length(); j++) {

			int index1 = input.lastIndexOf(orderStr.charAt(j - 1));
			int index2 = input.lastIndexOf(orderStr.charAt(j));

			if (index1 == -1 || index2 == -1 || index1 > index2) {
				valid = false;
				break;
			}
		}

		return valid;
	}

	public static void main(String args[]) {
		String input = "hello world!";
		System.out.println(isOrderTrue(input, "hlo"));
		System.out.println(isOrderTrue(input, "!od"));
		System.out.println(isOrderTrue(input, "he!"));
		System.out.println(isOrderTrue(input, "hw"));

		System.out.println(isOrderTrueNoSpace(input, "hlo"));
		System.out.println(isOrderTrueNoSpace(input, "!od"));
		System.out.println(isOrderTrueNoSpace(input, "he!"));
		System.out.println(isOrderTrueNoSpace(input, "hw"));

	}
}
