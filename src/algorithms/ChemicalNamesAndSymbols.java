package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChemicalNamesAndSymbols {

	public static List<String> getUpatedchemicalNames(
			List<String> chemicalNames, List<String> symbols) {
		List<String> result = new ArrayList<String>();

		Collections.sort(symbols, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		for (String chemicalName : chemicalNames) {
			for (String symbol : symbols) {
				int index = chemicalName.indexOf(symbol);
				if (index > -1) {
					StringBuilder str = new StringBuilder(chemicalName);
					str.insert(index, '[');
					str.insert(index + symbol.length() + 1, ']');
					result.add(str.toString());
					break;
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		List<String> chemicalNames = Arrays.asList(new String[] { "Amazon",
				"Microsoft", "Google" });
		List<String> symbols = Arrays.asList(new String[] { "i", "Am", "cro",
				"Na", "le", "abc" });
		System.out.println(getUpatedchemicalNames(chemicalNames, symbols));
	}
}
