package algorithms;

import java.util.Arrays;
import java.util.Random;

public class GameOfLife {
	public void play() {
		Random random = new Random();
		int[][] board = new int[5][5];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = random.nextInt(2);
			}
		}

		do {
			print(board);
		} while (gameOfLife(board));
	}

	private void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println("------------");
	}

	private boolean gameOfLife(int[][] board) {
		boolean changed = false;
		int[][] newBoard = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				newBoard[i][j] = board[i][j];
			}
		}

		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[i].length; j++) {
				int neighbors = getCount(newBoard, i, j);

				if (newBoard[i][j] == 1 && (neighbors < 2 || neighbors > 3)) {
					board[i][j] = 0;
					changed = true;
				} else if (newBoard[i][j] == 0 && neighbors == 3) {
					board[i][j] = 1;
					changed = true;
				}
			}
		}
		return changed;
	}

	private int getCount(int[][] board, int row, int col) {
		int count = -board[row][col];
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
					count += board[i][j];
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {
		new GameOfLife().play();
	}
}
