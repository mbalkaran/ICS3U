package balkaran;

/**
 * PerfectNumber.java
 * The program prints all perfect numbers from 1 - 1000 (perfect number being same number when all it's factors are added excluding itself)
 * 04/19/2017
 * @author Matthew Balkaran
 */
public class PerfectNumber {

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) { //i is the number being checked to be a perfect number or not
			int total = 0;
			for (int x = i - 1; x >= 1; x--) { //for loop for factors, starts at i - 1 so not to include itself as a number
				if (isDivisible(i,x)) {
					total = total + x; //if number is a factor of i it is added to a total
				}
			}
			if (total == i) { //if the factors found added together equal the original number it is a perfect number and it is printed
				System.out.println(i);
			}
		}
	}
	
	/**
	 * The method determines whether two numbers are divisible by each other
	 * @param i - The number being tested to be a perfect number (the numerator for method isDivisible)
	 * @param x - The number being tested as divisible, to be a factor of i (the denominator for method isDivisible)
	 * @return true or false - true means it is divisible (making it a factor of i), while false means it is not divisible
	 */
	public static boolean isDivisible (int i, int x) {
		if (i % x == 0) {
			return true;
		}
		return false;
	}	
}