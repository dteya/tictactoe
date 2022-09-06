package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	private static int[][] grid = new int[3][3];

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		buildGrid();
		
		displayGrid(grid);
		while (true) {
			player(grid, scanner);
			if (isGameOver(grid)) {
				break;
			}
			
			displayGrid(grid);
			
			comp();
			if (isGameOver(grid)) {
				break;
			}
			
			displayGrid(grid);
			
		}
		
		scanner.close();

	}
	
	private static int[][] buildGrid() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid[row][col] = 0;
			}
		}
		return grid;
	}
	
	private static void displayGrid(int[][] grid) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (grid[row][col] == 1) {
					System.out.print(" X");
				}
				else if (grid[row][col] == 2) {
					System.out.print(" O");
				}
				else {
					System.out.print(" _");
				}
			}
			System.out.println("");
			
		}
	}
	
	private static void player(int[][] grid, Scanner scanner) {
		
		System.out.println("Pick a row");
		int pRow = Integer.parseInt(scanner.nextLine()) - 1;
		
		System.out.println("Pick a col");
		int pCol = Integer.parseInt(scanner.nextLine()) - 1;
		
		grid[pRow][pCol] = 1;
					
		
		System.out.println("Player played");
	}
	
	private static void comp() {
		Random r = new Random();
		int low = 0;
		int high = 3; 
		
		boolean free = false;
		
		while (free == false) {
			int pRow = r.nextInt(high-low) + low;
			int pCol = r.nextInt(high-low) + low;
			if (grid[pRow][pCol] == 0) {
				grid[pRow][pCol] = 2;
				free = true;
			}
		}
		
		System.out.println("Comp Played");
	}
	
	private static boolean hasContestantWon(int[][] grid, int symbol) {
		if ((grid[0][0] == symbol && grid [0][1] == symbol && grid [0][2] == symbol) ||
		(grid[1][0] == symbol && grid [1][1] == symbol && grid [1][2] == symbol) ||
		(grid[2][0] == symbol && grid [2][1] == symbol && grid [2][2] == symbol) ||
		(grid[0][0] == symbol && grid [1][0] == symbol && grid [2][0] == symbol) ||
		(grid[0][1] == symbol && grid [1][1] == symbol && grid [2][1] == symbol) ||
		(grid[0][2] == symbol && grid [1][2] == symbol && grid [2][2] == symbol) ||
		(grid[0][0] == symbol && grid [1][1] == symbol && grid [2][2] == symbol) ||
		(grid[0][2] == symbol && grid [1][1] == symbol && grid [2][0] == symbol) ) {
			return true;
		}
		
		return false;
		}
	
	private static boolean isGameOver(int[][] grid) {
		if (hasContestantWon(grid, 1)) {
			displayGrid(grid);
			System.out.println("Player wins!");
			return true;
		}
		
		if (hasContestantWon(grid, 2)) {
			displayGrid(grid);
			System.out.println("Computer wins!");
			return true;
		}
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0 ) {
					return false;
				}
			}
		}
		
		displayGrid(grid);
		System.out.println("The game ended in a tie!");
		return true;
		}

}
