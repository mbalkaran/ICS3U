package balkaran;

/**
 * PythagoreanTriple.java
 * The program prints all pythagorean triples from each combination of a and b from 1-99
 * 04/19/2017
 * @author Matthew Balkaran
 */

public class PythagoreanTriple {

	public static void main(String[] args) {
		for (int a = 1; a <= 99; a++) {
			for (int b = 1; b <= 99; b++) {
				int c = (int)(Math.pow(a, 2) + Math.pow(b, 2));
				if (perfectSquare(c)) {
					c = (int) Math.sqrt(c);
					System.out.println(a + ", " + b + ", " + c);
				}
			}
		}	
	}
	
	/**
	 * The method determines whether a number is a perfect square
	 * @param n - c in the pythagorean theorm and the main method
	 * @return true or false - true if the number is a perfect square, false otherwise
	 */
	public static boolean perfectSquare (int n) {
		int x = (int)Math.sqrt(n);
		double check = Math.pow(x, 2);
		if (check == n)
			return true;
		return false;
	}
}