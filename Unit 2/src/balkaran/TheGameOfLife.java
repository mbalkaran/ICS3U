package balkaran;

import java.util.Scanner;

/**
 * TheGameOfLife.java
 * 
 * 4/24/2017
 * @author Matthew Balkaran
 */
public class TheGameOfLife {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] grid = new String [20][20];
		System.out.println("How many live cells would you like to start with?");
		String s = sc.nextLine();
		int numLiveCells = Integer.parseInt(s);
		System.out.println("Please enter the x cordinate followed by the y cordinate for each live cell in the corresponding area for the 20 x 20 grid");
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				grid[r][c] = "0";
			}
		}
		for (int i = 0; i < numLiveCells; i++) {
			System.out.println("X Coordinate #" + (i + 1) + ":");
			String s2 = sc.nextLine();
			int x = Integer.parseInt(s2) - 1;
			System.out.println("Y Coorinate #" + (i + 1) + ":");
			String s3 = sc.nextLine();
			int y = Integer.parseInt(s3) - 1;
			grid[x][y] = "X";
		}
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(grid[r][c]);
			}
			System.out.println();
		}
	}
	public static boolean rulesX (String[][] grid) {
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				if (grid[r][c].equals("X")) {
					
				}
			}
		}
	}
}