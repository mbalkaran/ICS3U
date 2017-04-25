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
		char[][] grid = new char [20][20];
		System.out.println("How many live cells would you like to start with?");
		String s = sc.nextLine();
		int numLiveCells = Integer.parseInt(s);
		System.out.println("Please enter the x cordinate followed by the y cordinate for each live cell in the corresponding area for the 20 x 20 grid");
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				grid[r][c] = '0';
			}
		}
		for (int i = 0; i < numLiveCells; i++) {
			System.out.println("X Coordinate #" + (i + 1) + ":");
			String s2 = sc.nextLine();
			int x = Integer.parseInt(s2) - 1;
			System.out.println("Y Coorinate #" + (i + 1) + ":");
			String s3 = sc.nextLine();
			int y = Integer.parseInt(s3) - 1;
			grid[x][y] = 'X';
		}
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(grid[r][c]);
			}
			System.out.println();
		}
		System.out.println("Is this okay as the starting grid?");
	}
	public static char position (char[][] grid, int r, int c) {
		int total = 0;
		if (grid[r][c] == 'X') {
			if (grid[r][c] == grid[0][0]){ //if cell is in the top left corner

			}
			else if (grid[r][c] == grid[19][0]){ //if cell is in the top right corner

			}
			else if (grid[r][c] == grid[19][19]){ //if cell is in the bottom right corner

			}
			else if (grid[r][c] == grid[0][19]){ //if cell is in the bottom left corner

			}
			else if (grid[r][c] == grid[r][0]){ //if cell is in top edge

			}
			else if (grid[r][c] == grid[r][19]){ //if cell is in bottom edge

			}
			else if (grid[r][c] == grid[0][c]){ //if cell is in left edge

			}
			else if (grid[r][c] == grid[19][c]){ //if cell is in right edge

			}
			else {
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (grid[r + x][c + x] == 'X' && (x != 1 && y != 1)) {
							total = total + 1;
						}
					}
				}
				if (total == 2 || total == 3) {
					grid[r][c] = 'X';
				}
				else {
					grid[r][c] = '0';
				}
			}
		}
		else if (grid[r][c] == '0') {
			if (grid[r][c] == grid[0][0]){ //if cell is in the top left corner

			}
			else if (grid[r][c] == grid[19][0]){ //if cell is in the top right corner

			}
			else if (grid[r][c] == grid[19][19]){ //if cell is in the bottom right corner

			}
			else if (grid[r][c] == grid[0][19]){ //if cell is in the bottom left corner

			}
			else if (grid[r][c] == grid[r][0]){ //if cell is in top edge

			}
			else if (grid[r][c] == grid[r][19]){ //if cell is in bottom edge

			}
			else if (grid[r][c] == grid[0][c]){ //if cell is in left edge

			}
			else if (grid[r][c] == grid[19][c]){ //if cell is in right edge

			}
			else {

			}
		}
	}
}