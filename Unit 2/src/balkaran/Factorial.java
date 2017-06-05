package balkaran;

import java.util.Scanner;

/**
 * Factorial.java
 * The program prints the factorial of a user-defined number 
 * 04/09/2017
 * @author Matthew Balkaran 
 */

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number to receive it's factorial");
		String s = sc.nextLine();
		int x = Integer.parseInt(s);
		System.out.println("The factorial of your number is " + factorial(x));
	}
	
	/**
	 * The method calculates the factorial of a single user-defined number
	 * @param x - the user-defined number for the factorial calculation
	 * @return -1 - factorial whenever the user defined input is less than 0
	 * @return 1 - factorial whenever the user defined input is 0
	 * @return product - calculated factorial of each number multiplied by each other
	 */
	public static int factorial(int x) {
		if (x < 0)
			return -1;
		if (x == 0)
			return 1;
		else {
			int product = x;
			while (x > 1) {
				product = product * (x - 1);
				x--;
			}
			return product;
		}
	} 
}