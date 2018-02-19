package algorithms;

public class ChangeNumberBase {

	public static String base(int number, int base) {
		String output = "";
		if (number == 0) {
			output = "0";
		} else {
			boolean negative = false;
			if (number < 0) {
				negative = true;
				number *= -1;
			}
			while (number > 0) {
				output = (number % base) + output;
				number = number / base;
			}
			if (negative)
				output = "-" + output;
		}
		return output;
	}

	public static void main(String args[]) {
		System.out.println(base(0, 3));
		System.out.println(base(3, 3));
		System.out.println(base(5, 3));
		System.out.println(base(-5, 3));
		System.out.println(base(9, 3));
		System.out.println(base(3, 4));
		System.out.println(base(4, 4));
		System.out.println(base(5, 4));
		System.out.println(base(15, 4));
	}
}
