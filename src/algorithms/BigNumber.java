package algorithms;

public class BigNumber {

	public static String add(String number1, String number2) {
		String output = "";
		int carry = 0;
		int index1 = number1.length() - 1;
		int index2 = number2.length() - 1;

		while (index1 >= 0 || index2 >= 0) {
			int digit1 = 0;
			if (index1 >= 0)
				digit1 = number1.charAt(index1--) - 48;

			int digit2 = 0;
			if (index2 >= 0)
				digit2 = number2.charAt(index2--) - 48;

			int sum = digit1 + digit2 + carry;
			if (sum > 9) {
				output = (sum - 10) + output;
				carry = 1;
			} else {
				output = sum + output;
				carry = 0;
			}
		}

		if (carry > 0)
			output = carry + output;

		return output;
	}

	public static String multiply(String number1, String number2) {
		String output = "";
		int carry = 0;
		String prevOutput = null;

		for (int index1 = number1.length() - 1; index1 >= 0; index1--) {
			int digit1 = number1.charAt(index1) - 48;
			String tmpOutput = "";
			carry = 0;
			for (int index2 = number2.length() - 1; index2 >= 0; index2--) {
				int digit2 = number2.charAt(index2) - 48;

				int multiply = (digit1 * digit2) + carry;
				if (multiply > 9) {
					tmpOutput = (multiply % 10) + tmpOutput;
					carry = multiply / 10;
				} else {
					tmpOutput = multiply + tmpOutput;
					carry = 0;
				}
			}
			if (carry > 0)
				tmpOutput = carry + tmpOutput;
			int numOfZeros = number1.length() - index1 - 1;
			while (numOfZeros-- > 0)
				tmpOutput = tmpOutput + "0";
			if (prevOutput != null) {
				output = add(prevOutput, tmpOutput);
				prevOutput = output;
			} else {
				output = tmpOutput;
				prevOutput = tmpOutput;
			}
		}

        while(output.charAt(0) == '0' && output.length() > 1)
            output = output.substring(1);

		return output;
	}

	public static void main(String args[]) {
		System.out.println("Test add");
		System.out.println(add("373", "121"));
		System.out.println(add("12353555", "1210"));
		System.out.println(add("12353555", "0"));
		System.out.println(add("99", "1"));
		System.out.println(add("999999999999999988", "12"));
		System.out.println(add("10000000000000000000", "10000000000000000000"));

		System.out.println("Test multiply");
		System.out.println(multiply("2", "12"));
		System.out.println(multiply("12", "2"));
		System.out.println(multiply("12", "20"));
		System.out.println(multiply("8", "6"));
		System.out.println(multiply("1211", "21"));
		System.out.println(multiply("12345", "10"));
		System.out.println(multiply("100000", "100000"));
		System.out.println(multiply("9999999999", "100000"));
		System.out.println(multiply("99999", "99999"));
		System.out.println(multiply("99999999", "99999999"));
	}
}
