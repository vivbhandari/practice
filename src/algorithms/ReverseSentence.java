package algorithms;

public class ReverseSentence {

	private static void swap(char[] input, int index1, int index2) {
		char tmp = input[index2];
		input[index2] = input[index1];
		input[index1] = tmp;
	}

	private static void reverse(char[] input, int startIndex, int endIndex) {
		// int mid = startIndex + (endIndex - startIndex + 1) / 2;
		// int mid = (startIndex + endIndex + 1) / 2;
		// for (int i = startIndex; i < mid; i++) {
		while (startIndex < endIndex) {
			swap(input, startIndex++, endIndex--);
		}
	}

	public static void reverseSentence(char[] sentence) {
		int length = sentence.length;
		reverse(sentence, 0, length - 1);
//		System.out.println(new String(sentence));
		int startIndex = 0;
		for (int i = 0; i <= length; i++) {
			if (i == length || sentence[i] == ' ') {
				reverse(sentence, startIndex, i - 1);
				startIndex = i + 1;
			}
		}
//		if (startIndex < length)
//			reverse(sentence, startIndex, length - 1);
	}

	public static void main(String args[]) {
		char[] sentence = " This   is Vivek ".toCharArray();
		reverseSentence(sentence);
		System.out.println(new String(sentence));
	}
}
