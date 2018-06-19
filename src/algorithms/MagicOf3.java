package algorithms;

public class MagicOf3 {

	public static void findNumberOfOnes(int number) {
		int count = 1; // number of 1s so far
		int remainder = 1; // 1 % number
		while (count < Integer.MAX_VALUE && remainder != 0) {
			remainder = (10 * remainder + 1) % number;
			count++;
		}

		while (count-- > 0)
			System.out.print("1");
	}

	public static void main(String args[]) {
		findNumberOfOnes(3);
		System.out.println();
		findNumberOfOnes(1313);
	}
}

/*******
  rem(1, num) = 1 % num 
  rem(2, num) = 11 % num 
  rem(3, num) = 111 % num 
  rem(i, num) = m(i) % num 
  rem(i+1, num) = m(i+1) % num
    => (10 * m(i) + 1) % num
    => (10 * m(i) % num + 1 % num) % num
    => (10 * rem(i) + 1) % num
 ******/
