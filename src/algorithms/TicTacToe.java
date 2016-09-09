package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TicTacToe {

	public static int player1 = 1;
	public static int player2 = 2;

	int[][] board;

	public TicTacToe(int n) {
		board = new int[n][n];
	}

	private int readInt(String msg) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		System.out.println(msg);
		while (num < 0) {
			try {
				num = Integer.parseInt(br.readLine());
				if (num < 0 || num > board.length - 1) {
					System.out.println("Enter a number in board range");
					num = -1;
				}
			} catch (Exception ex) {
				System.out.println("Enter a valid number");
				num = -1;
			}
		}
		return num;
	}

	private void nextMove(int currentPlayer) {
		do {
			int row = readInt("Enter row:");
			int col = readInt("Enter column:");

			if (board[row][col] != 0) {
				System.out.println("Slot is not available");
			} else {
				board[row][col] = currentPlayer;
				break;
			}
		} while (true);
	}

	private int gameOver() {
		boolean flag = true;
		boolean hasEmptySlots = false;
		int current;
		for (int row = 0; row < board.length; row++) {
			current = board[row][0];
			if (current != 0) {
				for (int col = 1; col < board.length; col++) {
					if (board[row][col] != current) {
						if (board[row][col] == 0) {
							hasEmptySlots = true;
						}
						flag = false;
						break;
					}
				}
				if (flag) {
					return current;
				} else {
					flag = true;
				}
			} else {
				hasEmptySlots = true;
			}
		}

		flag = true;
		for (int col = 0; col < board.length; col++) {
			current = board[0][col];
			if (current != 0) {
				for (int row = 1; row < board.length; row++) {
					if (board[row][col] != current) {
						if (board[row][col] == 0) {
							hasEmptySlots = true;
						}
						flag = false;
						break;
					}
				}
				if (flag) {
					return current;
				} else {
					flag = true;
				}
			} else {
				hasEmptySlots = true;
			}
		}

		current = board[0][0];
		if (current != 0) {
			flag = true;
			for (int row = 1, col = 1; row < board.length && col < board.length; row++, col++) {
				if (board[row][col] != current) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			return current;
		}

		current = board[board.length - 1][0];
		if (current != 0) {
			flag = true;
			for (int row = board.length - 2, col = 1; row >= 0
					&& col < board.length; row--, col++) {
				if (board[row][col] != current) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			return current;
		}

		if (hasEmptySlots) {
			return 0;
		} else {
			return -1;
		}
	}

	private String getDisplayStr(int value) {
		String str = "";
		if (value == 0) {
			str = "_";
		} else if (value == 1) {
			str = "0";
		} else {
			str = "X";
		}
		return str;
	}

	private void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(getDisplayStr(board[i][j]) + " ");
			}
			System.out.println("");
		}
	}

	public void play() {
		int currentPlayer = player1;
		while (true) {
			printBoard();
			System.out.println(getDisplayStr(currentPlayer) + "'s turn");
			nextMove(currentPlayer);
			int result = gameOver();
			if (result == -1) {
				printBoard();
				System.out.println("Game drawn");
				break;
			} else if (result == 0) {
				currentPlayer = currentPlayer == player1 ? player2 : player1;
			} else {
				printBoard();
				System.out.println(getDisplayStr(currentPlayer) + " won!");
				break;
			}
		}
	}

	public static void main(String args[]) {
		TicTacToe game = new TicTacToe(3);
		game.play();
	}
}
