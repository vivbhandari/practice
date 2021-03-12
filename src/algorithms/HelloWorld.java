package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HelloWorld {
	public static void main(String args[]) throws IOException {

		System.out.println("Hello World!");

		System.out.println(Math.abs(-1));
		System.out.println(Math.abs(Integer.MAX_VALUE));
		System.out.println(Math.abs(Integer.MIN_VALUE));

		Random random = ThreadLocalRandom.current();
		byte[] randomBytes = new byte[4];
		random.nextBytes(randomBytes);
		System.out.println("bytes size: " + randomBytes.length);
		String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
		System.out.println("encoded size: " + encoded.length());
		System.out.println("encoded: " + encoded.substring(0, 6));

		int i = 1;
		while (++i < 5)
			;
		System.out.println(i);

		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		System.out.println("Enter name:");
		String name = br.readLine();

		System.out.println("Enter Age:");
		int age = -1;
		do {
			try {
				age = Integer.parseInt(br.readLine());
				if (age < 1) {
					System.out.println("Age can't be less than 1");
				}
			} catch (NumberFormatException nEx) {
				System.out.println("Enter a valid positive number");
				age = -1;
			}
		} while (age < 1);

		System.out.println("Hello " + age + " year old " + name);
	}
}
