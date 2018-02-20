package algorithms;

public class MagicOf3 {

	public static void findNumberOfOnes(int number) {
		int count = 1; // number of 1s so far
		int remainder = 1; // 1 % number
		while (count < Integer.MAX_VALUE) {
			if (remainder == 0) {
				break;
			} else {
				remainder = (10 * remainder + 1) % number;
				count++;
			}
		}
		for (int j = 0; j < count; j++)
			System.out.print("1");
		System.out.println("");
	}

	public static void main(String args[]) {
		findNumberOfOnes(3);
		findNumberOfOnes(13);
		findNumberOfOnes(131313);
	}
}

/*
  r(1, n) = 1 % n
  r(2, n) = 11 % n
  r(i, n) = m(i) % n
  r(i+1, n) = m(i+1)  % n
  => (10 * m(i) + 1) % n
  => (10 * m(i) % n + 1 % n) % n
  => (10 * r(i, n) + 1) % n 
 */

