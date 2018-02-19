package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RearrangeCharactersOrder {

	public static String rearrange(String s1, String s2) {
		String output = "";
		Character[] s1Array = new Character[s1.length()];
		HashMap<Character, Integer> positions = new HashMap<Character, Integer>();

		for (int i = 0; i < s2.length(); i++) {
			char ch = Character.toLowerCase(s2.charAt(i));
			if (!positions.containsKey(ch)) {
				positions.put(ch, i);
			}
		}

		for (int i = 0; i < s1.length(); i++) {
			char ch = Character.toLowerCase(s1.charAt(i));
			s1Array[i] = ch;
			if (!positions.containsKey(ch)) {
				positions.put(ch, s2.length() + i);
			}
		}

		Comparator<Character> s1Comparator = new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return positions.get(o1) - positions.get(o2);
			}
		};

		Arrays.sort(s1Array, s1Comparator);
		output = Arrays.stream(s1Array).map(Object::toString)
				.collect(Collectors.joining());

		return output;
	}

	public static void main(String args[]) {
		System.out.println(rearrange("google", "dog"));
		System.out.println(rearrange("Google", "Dog"));
		System.out.println(rearrange("abcdedadf", "cae"));
	}
}
