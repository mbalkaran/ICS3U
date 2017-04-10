package balkaran;

import java.util.Scanner;

/**
 * SumOfDigits.java
 * The program prints the sum of individual digits in a user-defined number
 * 04/09/2017
 * @author Matthew Balkaran 
 */

public class SumOfDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number to receive it's sum of each digit");
		String s = sc.nextLine();
		int x = Integer.parseInt(s);
		System.out.println("The sum of each of your number's digits is " + sumOfDigits(x));
	}
	
	/**
	 * The method calculates and sends back the sum of each digit in the user-defined number
	 * @param x - The user-defined number in which its sum is being found
	 * @return total - The sum of each individual digit in the number
	 */
	public static int sumOfDigits(int x) {
		int total = 0;
		while (x > 0) {
			total = total + x % 10;
			x = x / 10;
		}
		return total;
	}
}