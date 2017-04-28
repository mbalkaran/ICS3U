package balkaran;

import java.util.Scanner;

/**
 * TheGameOfLife.java
 * The program follows Conway's Game of Life and it's set rules for the game
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
		System.out.println("(1, 1) is the top left while (20, 20) is the bottom right");
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				grid[r][c] = '0'; //initializes grid
			}
		}
		for (int i = 0; i < numLiveCells; i++) {
			System.out.println("X Coordinate #" + (i + 1) + ":");
			String s2 = sc.nextLine();
			int x = Integer.parseInt(s2) - 1;
			System.out.println("Y Coorinate #" + (i + 1) + ":");
			String s3 = sc.nextLine();
			int y = Integer.parseInt(s3) - 1;
			grid[y][x] = 'X'; //replaces initialization grid spots with user coordinates
		}
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(grid[r][c]); //prints final beginning grid using for loop and previous information
				System.out.print(" ");
			}
			System.out.println();
		}
		String userContinue;
		char[][] newGrid = new char [20][20]; //declares new grid to place new chars after test
		do {
			System.out.println();
			System.out.println("Would you like to continue? (Y/N)");
			userContinue = sc.nextLine();
			if (userContinue.equalsIgnoreCase("Y")) {
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 20; c++) {
						if (positionRules(grid, r, c)) {
							newGrid[r][c] = 'X';
							System.out.print(newGrid[r][c]); //cell is printed as alive
							System.out.print(" ");
						}
						else {
							newGrid[r][c] = '0';
							System.out.print(newGrid[r][c]); //cell is printed as dead
							System.out.print(" ");
						}
					}
					System.out.println();
				}
				for (int r = 0; r < 20; r++) {
					for (int c = 0; c < 20; c++) {
						grid[r][c] = newGrid[r][c]; //sets old grid tested to new grid for next test
					}
				}
			}
			if (gameOver(grid)) { //ends if all cells are dead
				System.out.println();
				System.out.println("Game Over!");
			}
			else if (userContinue.equalsIgnoreCase("N")){
				System.out.println("Thanks for playing!");
			}

		} while (userContinue.equalsIgnoreCase("Y") && !(gameOver(grid))); //does not allow user to continue if all cells are dead
	}

	/**
	 * The method determines whether a cell that was alive remains alive and whether a cell that was dead remains dead
	 * @param grid - The current initialized grid of live cells and dead cells
	 * @param r - Current row in the grid (combines with c to become position in grid)
	 * @param c - Current column in the grid (combines with r to become position in grid)
	 * @return true or false - true means a cell will come alive/remain alive and false means a cell will die/remain dead
	 */
	public static boolean positionRules (char[][] grid, int r, int c) {
		int total = 0; //total added to each time a surrounding cell is alive
		if (r - 1 != -1) { //tests that one up is not off the grid
			if (grid[r - 1][c] == 'X') {
				total++;
			}
		}
		if (r + 1 != 20) { //tests that one down is not off the grid
			if (grid[r + 1][c] == 'X') {
				total++;
			}
		}
		if (c + 1 != 20) { //tests that one right is not off the grid
			if (grid[r][c + 1] == 'X') {
				total++;
			}
		}
		if (c - 1 != -1) { //tests that one left is not off the grid
			if (grid[r][c - 1] == 'X') {
				total++;
			}
		}
		if ((r + 1 != 20) && (c + 1 != 20)) { //tests that one down-right is not off the grid
			if (grid[r + 1][c + 1] == 'X') {
				total++;
			}
		}
		if ((r - 1 != -1) && (c - 1 != -1)) { //tests that one up-left is not off the grid
			if (grid[r - 1][c - 1] == 'X') {
				total++;
			}
		}
		if ((r + 1 != 20) && (c - 1 != -1)) { //tests that one down-left is not off the grid
			if (grid[r + 1][c - 1] == 'X') {
				total++;
			}
		}
		if ((r - 1 != -1) && (c + 1 != 20)) { //tests that one up-right is not off the grid
			if (grid[r - 1][c + 1] == 'X') {
				total++;
			}
		}
		if (grid[r][c] == 'X') { //tests if position in grid is alive
			if (total == 2 || total == 3) { //test to stay alive
				return true; //remains alive
			}
			else {
				return false; //becomes dead
			}
		}
		else { //applies if position in grid is not alive
			if (total == 3) { //test to become alive
				return true; //becomes alive
			}
			else {
				return false; //remains dead
			}
		}
	}

	/**
	 * The method determines whether the game will end if all cells are dead
	 * @param grid - The current initialized grid of live cells and dead cells
	 * @return true or false - true means all cells are dead and the game will end and false means there are still cells alive, the game will not end
	 */
	public static boolean gameOver (char[][] grid) {
		int gameOver = 0;
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				if (grid[r][c] == '0') {
					gameOver++; //checks all cells and keeps counter
				}	
			}
		}
		if (gameOver == 400) { // 20 x 20 = 400, accounts for all cells to be dead
			return true;
		}
		else {
			return false;
		}
	}
}