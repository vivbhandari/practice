package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWorld {
	public static void main(String args[]) throws IOException {

		System.out.println("Hello World!");

		int i = 1;
		while (++i < 5)
			;
		System.out.println(i);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
