package algorithms;

public class MagicOf3 {

	public static void findNumberOfOnes(int number) {
		int i = 1;
		int m = 1;
		while (i < number) {
			if (m == 0) {
				break;
			} else {
				m = (10 * m + 1) % number;
				i++;
			}
		}
		for (int j = 0; j < i; j++)
			System.out.print("1");
	}

	public static void main(String args[]) {
		findNumberOfOnes(133);
	}
}
