package balkaran;

import java.util.Scanner;

/**
 * LargestNumber.java
 * The program prints the largest number of a set of user-defined numbers with a user specified set length
 * 04/09/2017
 * @author Matthew Balkaran 
 */

public class LargestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many numbers would you like to enter?");
		String s = sc.nextLine();
		int n = Integer.parseInt(s);
		int a[] = new int[n];
		System.out.println("Please enter those numbers.");
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println("The largest number in your set of numbers was " + largestNum(a));
	}
	
	/**
	 * The method determines the largest number of the array of numbers previously entered by the user
	 * @param []array - the set of numbers entered into the array by the user in which the largest number is found 
	 * @return largestNumber - the largest number in the set of user-defined numbers
	 */
	public static int largestNum (int[]array) {
		int largestNumber = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > largestNumber)
				largestNumber = array[i];
		}
		return largestNumber;
	}
}