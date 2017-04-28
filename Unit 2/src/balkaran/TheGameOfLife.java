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
			grid[y][x] = 'X';
		}
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(grid[r][c]);
			}
			System.out.println();
		}
		String userContinue;
		char[][] newGrid = new char [20][20];
		do {
			System.out.println();
			System.out.println("Would you like to continue? (Y/N)");
			userContinue = sc.nextLine();
			if (userContinue.equalsIgnoreCase("Y")) {
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 20; c++) {
						newGrid[r][c] = positionRules(grid, r, c);
						System.out.print(newGrid[r][c]);
					}
					System.out.println();
				}
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 20; c++) {
						grid[r][c] = newGrid[r][c];
					}
				}
			}
			else {
				System.out.println("Thanks for playing!");
			}
		} while (userContinue.equalsIgnoreCase("Y"));
	}

	
	public static char positionRules (char[][] grid, int r, int c) {
		int total = 0;
		if (grid[r][c] == grid[0][0]){ //if cell is in the top left corner
			if (grid[0][1] == 'X') {
				total++;
			}
			if (grid[1][1] == 'X') {
				total++;
			}
			if (grid[1][0] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (grid[r][c] == grid[19][0]){ //if cell is in the bottom left corner
			if (grid[19][1] == 'X') {
				total++;
			}
			if (grid[18][1] == 'X') {
				total++;
			}
			if (grid[18][0] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (grid[r][c] == grid[19][19]){ //if cell is in the bottom right corner
			if (grid[18][18] == 'X') {
				total++;
			}
			if (grid[18][19] == 'X') {
				total++;
			}
			if (grid[19][18] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (grid[r][c] == grid[0][19]){ //if cell is in the top right corner
			if (grid[1][18] == 'X') {
				total++;
			}
			if (grid[1][19] == 'X') {
				total++;
			}
			if (grid[0][18] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (r == 0){ //if cell is in top edge
			if (grid[r + 1][c] == 'X') {
				total++;
			}
			if (grid[r + 1][c + 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c - 1] == 'X') {
				total++;
			}
			if (grid[r][c - 1] == 'X') {
				total++;
			}
			if (grid[r][c + 1] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (r == 19){ //if cell is in bottom edge
			if (grid[r - 1][c] == 'X') {
				total++;
			}
			if (grid[r - 1][c - 1] == 'X') {
				total++;
			}
			if (grid[r - 1][c + 1] == 'X') {
				total++;
			}
			if (grid[r][c - 1] == 'X') {
				total++;
			}
			if (grid[r][c + 1] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (c == 0){ //if cell is in left edge
			if (grid[r][c + 1] == 'X') {
				total++;
			}
			if (grid[r - 1][c + 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c + 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c] == 'X') {
				total++;
			}
			if (grid[r - 1][c] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else if (c == 19){ //if cell is in right edge
			if (grid[r][c - 1] == 'X') {
				total++;
			}
			if (grid[r - 1][c - 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c - 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c] == 'X') {
				total++;
			}
			if (grid[r - 1][c] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
		else { //if cell is in center position (no edges)
			if (grid[r - 1][c] == 'X') {
				total++;
			}
			if (grid[r + 1][c] == 'X') {
				total++;
			}
			if (grid[r][c + 1] == 'X') {
				total++;
			}
			if (grid[r][c - 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c + 1] == 'X') {
				total++;
			}
			if (grid[r - 1][c - 1] == 'X') {
				total++;
			}
			if (grid[r + 1][c - 1] == 'X') {
				total++;
			}
			if (grid[r - 1][c + 1] == 'X') {
				total++;
			}
			if ((total == 2 || total == 3) && grid[r][c] == 'X') {
				return 'X';
			}
			else if (total == 3) {
				return 'X';
			}
			else {
				return '0';
			}
		}
	}
}