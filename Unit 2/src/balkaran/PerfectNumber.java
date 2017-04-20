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
				if (i % x == 0) { //checks to see if the number is a factor of i
					total = total + x; //if number is a factor of i it is added to a total
				}
			}
			if (total == i) { //if the factors found added together equal the original number it is a perfect number and it is printed
				System.out.println(i);
			}
		}
	}
}