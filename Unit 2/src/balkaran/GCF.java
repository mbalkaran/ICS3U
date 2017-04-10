package balkaran;

import java.util.Scanner;

/**
 * GCF.java
 * The program prints out the GCF of two user-defined numbers 
 * 04/09/2017
 * @author Matthew Balkaran 
 */

public class GCF {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter two numbers to receive their GCF");
		String x = sc.nextLine();
		int a = Integer.parseInt(x);
		String y = sc.nextLine();
		int b = Integer.parseInt(y);
		System.out.println("The GCF of your numbers is " + greatestCommonFactor(a, b));
	}
	
	/**
	 * The method calculates the GCF of the two user-defined numbers
	 * @param a, b - user-defined numbers, GCF is found and declares them big and small correspondingly
	 * @return i - The gcf found by the for loop in this method
	 * @return 1 - The gcf if no gcf is found in the for loop (thus meaning it has to be 1)
	 */
	public static int greatestCommonFactor(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		for (int i = small; i > 0; i--) {
			if ((isDivisible(big, i)) && (isDivisible(small, i))) {
				return i;
			}
		}
		return 1;
	}
	
	/**
	 * The method determines whether two numbers are divisible by each other
	 * @param x - The user-defined number (in the previous method), the numerator
	 * @param y - The counter for the loop (in the previous method), the denominator
	 * @return true or false - true means it is divisible, while false means it is not divisible
	 */
	public static boolean isDivisible (int x, int y) {
		if (x % y == 0) {
			return true;
		}
		return false;
	}
}