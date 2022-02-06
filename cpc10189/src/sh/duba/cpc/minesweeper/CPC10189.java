package sh.duba.cpc.minesweeper;

import java.util.Scanner;

/**
 * 10189 — Minesweeper
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=29&page=show_problem&problem=1130
 * @author Jacob Duba
 */
class CPC10189 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int minefeildCounter = 0;
		try {
			while (scan.hasNext()) {
				int row = scan.nextInt();
				int col = scan.nextInt();
				scan.nextLine();
				
				// Turn standard input into 2d array
				char[][] toSolve = new char[row][col];
				for (int x = 0; x < row; x++) {
					String line = scan.nextLine();
					for (int y = 0; y < col; y++) {
						toSolve[x][y] = line.charAt(y);
					}
				}

				// Main logic
				String[][] solved = new String[row][col];
				for (int r = 0; r < row; r++) {
					for (int c = 0; c < col; c++) {
						if (toSolve[r][c] == '*') {
							solved[r][c] = "*";
						} else {
							// Naive implementation
							int aroundMineCount = 0;
							if (r - 1 > -1 && c - 1 > -1 && toSolve[r - 1][c - 1] == '*') {
								aroundMineCount++;
							}
							if (c - 1 > -1 && toSolve[r][c - 1] == '*') {
								aroundMineCount++;
							} 
							if (r + 1 < toSolve.length && c - 1 > -1 && toSolve[r + 1][c - 1] == '*') {
								aroundMineCount++;
							} 
							if (r - 1 > -1 && toSolve[r -1][c] == '*') {
								aroundMineCount++;
							} 
							if (r + 1 < toSolve.length && toSolve[r +1][c] == '*') {
								aroundMineCount++;
							} 
							if (r - 1 > -1 && c + 1 < toSolve[r].length && toSolve[r - 1][c + 1] == '*') {
								aroundMineCount++;
							} 
							if (c + 1 < toSolve[r].length && toSolve[r][c + 1] == '*') {
								aroundMineCount++;
							} 
							if (r + 1 < toSolve.length && c + 1 < toSolve[r].length && toSolve[r + 1][c + 1] == '*') {
								aroundMineCount++;
							}
							solved[r][c] = Integer.toString(aroundMineCount);
						}

					}
				}

				if (row != 0 && col != 0) {
					System.out.printf("Field #%d:%n", ++minefeildCounter);
					for (int x = 0; x < row; x++) {
						for (int y = 0; y < col; y++) {
							System.out.print(solved[x][y]);
						}
						System.out.println();
					}
					System.out.println();
				}
				
			}
			scan.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}