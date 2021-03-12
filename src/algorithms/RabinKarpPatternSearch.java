package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpPatternSearch {

	int alphabetLen = 256;
	int primeNum = 131;

	public List<Integer> find(String text, String pattern) {
		List<Integer> output = new ArrayList<Integer>();
		int textLen = text.length();
		int patLen = pattern.length();
		int textHash = 0;
		int patHash = 0;
		int topHash = (int) (Math.pow(alphabetLen, patLen - 1) % primeNum);

		for (int i = 0; i < patLen; i++) {
			patHash = ((alphabetLen * patHash) + pattern.charAt(i)) % primeNum;
			textHash = ((alphabetLen * textHash) + text.charAt(i)) % primeNum;
		}

		for (int i = 0; i <= textLen - patLen; i++) {
			if (textHash == patHash) {
				int j;
				for (j = 0; j < patLen; j++) {
					if (text.charAt(i + j) != pattern.charAt(j))
						break;
				}

				if (j == patLen)
					output.add(i);
			}

			if (i < textLen - patLen) {
				int textHashWithoutFirst = textHash
						- (text.charAt(i) * topHash) % primeNum;
				textHash = (alphabetLen * textHashWithoutFirst
						+ text.charAt(i + patLen)) % primeNum;

				if (textHash < 0)
					textHash += primeNum;
			}
		}

		return output;
	}

	public static void main(String args[]) {
		RabinKarpPatternSearch ps = new RabinKarpPatternSearch();
		System.out.println(ps.find("GEEKS FOR GEEKS", "GEEK"));
		System.out.println(ps.find("tables are not fun", "not fun"));
	}
}
