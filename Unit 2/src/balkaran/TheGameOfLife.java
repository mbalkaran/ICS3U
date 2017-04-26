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
		String userContinue = sc.nextLine();
		boolean test;
		System.out.println();
		System.out.println("Would you like to continue? (Y/N");
		for (int r = 0; r < 20; r++) {
			for (int c = 0; c < 20; c++) {
				System.out.print(grid[r][c] = positionRules(grid, r, c));
			}
			System.out.println();
		}
	}

	public static char positionRules (char[][] grid, int r, int c) {
		int total = 0;
		if (grid[r][c] == 'X') { //if cell is initially alive
			if (grid[r][c] == grid[0][0]){ //if cell is in the top left corner
				if (grid[0][1] == 'X') {
					total = total + 1;
				}
				if (grid[1][1] == 'X') {
					total = total + 1;
				}
				if (grid[1][0] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[19][0]){ //if cell is in the top right corner
				if (grid[19][1] == 'X') {
					total = total + 1;
				}
				if (grid[18][1] == 'X') {
					total = total + 1;
				}
				if (grid[18][0] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[19][19]){ //if cell is in the bottom right corner
				if (grid[18][18] == 'X') {
					total = total + 1;
				}
				if (grid[18][19] == 'X') {
					total = total + 1;
				}
				if (grid[19][18] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[0][19]){ //if cell is in the bottom left corner
				if (grid[1][18] == 'X') {
					total = total + 1;
				}
				if (grid[1][19] == 'X') {
					total = total + 1;
				}
				if (grid[0][18] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[r][0]){ //if cell is in top edge
				if (grid[r][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[r][19]){ //if cell is in bottom edge
				if (grid[r][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[0][c]){ //if cell is in left edge
				if (grid[r][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[19][c]){ //if cell is in right edge
				if (grid[r][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (total == 2 | total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else { //if cell is in center position (no edges)
				for (int x = -1; x < 2; x++) {
					for (int y = -1; y < 2; y++) {
						if (grid[r + x][c + x] == 'X' && (x != 0 && y != 0)) {
							total = total + 1;
						}
					}
				}
				if (total == 2 || total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
		}
		else if (grid[r][c] == '0') { //if cell is initially dead
			if (grid[r][c] == grid[0][0]){ //if cell is in the top left corner
				if (grid[0][1] == 'X' && grid[1][1] == 'X' && grid[1][0] == 'X') {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[19][0]){ //if cell is in the top right corner
				if (grid[19][1] == 'X' && grid[18][1] == 'X' && grid[18][0] == 'X') {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[19][19]){ //if cell is in the bottom right corner
				if (grid[18][18] == 'X' && grid[18][19] == 'X' && grid[19][18] == 'X') {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[0][19]){ //if cell is in the bottom left corner
				if (grid[0][18] == 'X' && grid[1][19] == 'X' && grid[1][18] == 'X') {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[r][0]){ //if cell is in top edge
				if (grid[r][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[r][19]){ //if cell is in bottom edge
				if (grid[r][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[0][c]){ //if cell is in left edge
				if (grid[r][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r + 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else if (grid[r][c] == grid[19][c]){ //if cell is in right edge
				if (grid[r][c + 1] == 'X') {
					total = total + 1;
				}
				if (grid[r][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c - 1] == 'X') {
					total = total + 1;
				}
				if (grid[r - 1][c + 1] == 'X') {
					total = total + 1;
				}
				if (total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
			else { //if cell is in center position (no edges)
				for (int x = -1; x < 2; x++) {
					for (int y = -1; y < 2; y++) {
						if (grid[r + x][c + x] == 'X' && (x != 0 && y != 0)) {
							total = total + 1;
						}
					}
				}
				if (total == 3) {
					return 'X';
				}
				else {
					return '0';
				}
			}
		}
		return 'W'; //Meant to stand out for error checking
	}
}