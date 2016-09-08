package algorithms;

public class MagicOf3 {

	public static void findNumberOfOnes(int number) {
		int i = 1;
		int m = 1;
		while (i < Integer.MAX_VALUE) {
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
		findNumberOfOnes(131313);
	}
}

/*
  r(0, n) = 1 % n
  r(1, n) = 11 % n
  r(i, n) = m(i) % n
  r(i+1, n) = m(i+1)  % n
  => (10 * m(i) + 1) % n
  => (10 * m(i) % n + 1 % n) % n
  => (10 * r(i) + 1) % n 
 */

