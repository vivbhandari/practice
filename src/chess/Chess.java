package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Chess {
	private Piece[][] board;
	private King kingWhite;
	private King kingBlack;

	private void init() {
		board = new Piece[8][8];
		kingWhite = new King(Color.WHITE);
		kingBlack = new King(Color.BLACK);

		for (Color color : Color.values()) {
			int mainRow;
			int pawnRow;
			int kingColumn;
			int queenColumn;
			King king;
			if (color == Color.WHITE) {
				mainRow = 0;
				pawnRow = 1;
				kingColumn = 3;
				queenColumn = 4;
				king = kingWhite;
			} else {
				mainRow = 7;
				pawnRow = 6;
				kingColumn = 4;
				queenColumn = 3;
				king = kingBlack;
			}

			king.setCurrentX(mainRow);
			king.setCurrentY(kingColumn);

			board[mainRow][kingColumn] = king;
			board[mainRow][queenColumn] = new Queen(color, mainRow, queenColumn);
			board[mainRow][2] = new Bishop(color, mainRow, 2);
			board[mainRow][5] = new Bishop(color, mainRow, 5);
			board[mainRow][1] = new Knight(color, mainRow, 1);
			board[mainRow][6] = new Knight(color, mainRow, 6);
			board[mainRow][0] = new Rook(color, mainRow, 0);
			board[mainRow][7] = new Rook(color, mainRow, 7);
			for (int i = 0; i < 8; i++) {
				board[pawnRow][i] = new Pawn(color, pawnRow, i);
			}
		}
	}

	public Chess() {
		init();
	}

	public void printBoard() {
		for (int row = -1; row < 9; row++) {
			for (int col = -1; col < 9; col++) {
				if (col == -1 || col == 8) {
					if (row == -1 || row == 8) {
						System.out.print("     ");
					} else {
						System.out.print(" " + row + "  ");
					}
				} else if (row == -1 || row == 8) {
					System.out.print(col + "  ");
				} else if (board[row][col] == null) {
					System.out.print("-- ");
				} else {
					System.out.print(board[row][col] + " ");
				}
			}
			System.out.println("");
		}
	}

	private int readValidInt(String message) {
		int input = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(message);

		while (true) {
			try {
				input = Integer.parseInt(br.readLine());
				if (input >= 0 && input <= 7) {
					break;
				} else {
					System.out.println("Enter a number between 0 and 7");
				}
			} catch (NumberFormatException nEx) {
				System.out.println("Enter a number between 0 and 7");
			} catch (IOException e) {
				System.out.println("IO Exception, try again...");
			}
		}

		return input;
	}

	public void nextMove(Color currentColor) {
		do {
			System.out.println(currentColor.toString() + "'s move ->");
			int curX = readValidInt("Enter row number of the piece:");
			int curY = readValidInt("Enter column number of the piece:");

			Piece curPiece = board[curX][curY];
			if (curPiece == null || curPiece.getColor() != currentColor) {
				String error = curPiece != null ? "Invalid piece "
						+ curPiece.toString() : "Empty square";
				System.out.println(error + " selected, try again...");
				continue;
			}

			int nextX = readValidInt("Enter row number of next position:");
			int nextY = readValidInt("Enter column number of next position:");

			if (curX == nextX && curY == nextY) {
				System.out
						.println("Next position is same as current position, try again...");
			} else if (curPiece.isValidMove(board, nextX, nextY)) {
				Piece deletedPiece = board[nextX][nextY];
				board[nextX][nextY] = curPiece;
				board[curX][curY] = null;
				curPiece.setCurrentX(nextX);
				curPiece.setCurrentY(nextY);
				if (isCheck(currentColor, true)) {
					System.out.println("King in check, try again...");
					// revert the move
					board[nextX][nextY] = deletedPiece;
					board[curX][curY] = curPiece;
					curPiece.setCurrentX(curX);
					curPiece.setCurrentY(curY);
				} else {
					break;
				}
			} else {
				System.out.println("Invalid move, try again...");
				this.printBoard();
			}

		} while (true);
	}

	public boolean isCheck(Color currentColor) {
		return this.isCheck(currentColor, false);
	}

	public boolean isCheck(Color currentColor, boolean ignoreCheckmate)
			throws CheckMate {
		boolean check = false;
		Color otherColor = Color.BLACK;
		King king = kingWhite;
		if (currentColor == Color.BLACK) {
			otherColor = Color.WHITE;
			king = kingBlack;
		}
		king.reinitializeCheckBitSet(board);

		List<Piece> attackingPieces = new ArrayList<Piece>();
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Piece piece = board[row][col];
				if (piece != null && piece.getColor() == otherColor) {
					if (piece.attackingKing(board, king)) {
						attackingPieces.add(piece);
						check = true;
					}
				}
			}
		}

		if (check && !ignoreCheckmate) {
			if (king.getCheckBitSet().nextSetBit(0) == -1) {
				boolean canSaveKing = false;
				if (attackingPieces.size() == 1) {
					for (int row = 0; row < 8; row++) {
						for (int col = 0; col < 8; col++) {
							Piece piece = board[row][col];
							if (piece != null && piece != king
									&& piece.getColor() == currentColor) {
								if (piece.canSaveKing(board, king,
										attackingPieces.get(0))) {
									canSaveKing = true;
								}
							}
						}
					}
				}

				if (!canSaveKing) {
					throw new CheckMate();
				}
			}
		}
		return check;
	}

	@SuppressWarnings("serial")
	class CheckMate extends RuntimeException {
	}

	public static void main(String args[]) {
		System.out.println("New Game");
		System.out.println("*w= White pieces");
		System.out.println("*b= Black pieces");

		Chess chess = new Chess();
		boolean gameOver = false;
		Color currentColor = Color.WHITE;

		do {
			chess.printBoard();
			chess.nextMove(currentColor);
			currentColor = currentColor == Color.WHITE ? Color.BLACK
					: Color.WHITE;
			try {
				boolean check = chess.isCheck(currentColor);
				if (check) {
					System.out.println("CHECK!");
				}
			} catch (CheckMate e) {
				chess.printBoard();
				System.out.println("CHECKMATE king " + currentColor);
				gameOver = true;
			}
		} while (!gameOver);
	}
}
