/**
 * 
 */
package balkaran;

import java.util.Scanner;

/**
 * ReverseSentence.java
 * The program prints out each word of a user-defined sentence backwards
 * 04/09/2017
 * @author Matthew Balkaran 
 */

public class ReverseSentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please type a sentence");
		String[] myString = sc.nextLine().split(" ");
		for (int i = 0; i < myString.length; i++) {
			for (int j = myString[i].length() - 1; j >= 0; j--) {
				System.out.print(myString[i].charAt(j));
			}
			System.out.print(" ");
		}
	}
}
