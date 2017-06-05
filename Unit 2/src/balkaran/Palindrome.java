package balkaran;

import java.util.Scanner;

/**
 * Palindrome.java
 * This program accepts a user-inputed string and tests if it's a palindrome
 * 04/13/2017
 * @author Matthew Balkaran
 */

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a word");
		String pTest = sc.nextLine();
		if (isPalindrome(pTest) == true) {
			System.out.println("Your word is a palindrome");
		}
		else {
			System.out.println("Your word is not a palindrome");
		}
	}
	
	/**
	 * The method determines the user-defined String to be a palindrome or not a palindrome
	 * @param pTest - The user-defined string being tested to either be a palindrome or not a palindrome
	 * @return true or false - true means it is a palindrome, false means it is not a palindrome
	 */
	public static boolean isPalindrome (String pTest) {
		String s = "";
		for (int i = pTest.length() - 1; i >= 0; i--) {
			s = s + pTest.charAt(i); //reverses pTest and stores it inside s
		}
		if (s.equals(pTest)) { 
			return true; //a Palindrome being true means the word is the same forwards and backwards
		}
		return false;
	}
}
