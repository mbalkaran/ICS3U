package balkaran;

import java.util.Scanner;

/**
 * Prime.java
 * The program prints whether a user-defined number is prime or not
 * 04/09/2017
 * @author Matthew Balkaran 
 */

public class Prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number to find out if it's prime");
		String s = sc.nextLine();
		int x = Integer.parseInt(s);
		if (isPrime(x)==true) 
			System.out.println("Your number is prime!");
		else
			System.out.println("Your number is not prime!");
	}
	
	/**
	 * The method determines the user-defined number to be prime or not prime
	 * @param x - The user-defined number determined to either be prime or not prime
	 * @return true or false - true means it is prime, while false means it is not prime
	 */
	public static boolean isPrime (int x) {
		if (x <= 0)
			return false;
		else {
			for (int i = (int) Math.sqrt(x); i > 1; i--) {
				if (isDivisible(x, i))
						return false;
			}
			return true;
		}
	}
	
	/**
	 * The method determines whether two numbers are divisible by each other
	 * @param x - The user-defined number (in the previous method), the numerator
	 * @param i - The counter for the loop (Begins at square root of user-defined number and counts down from there (in the previous method)), the denominator
	 * @return true or false - true means it is divisible, while false means it is not divisible
	 */
	public static boolean isDivisible (int x, int i) {
		if (x % i == 0) {
			return true;
		}
		return false;
	}	
}