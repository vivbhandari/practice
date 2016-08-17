package chess;

import java.util.BitSet;

public class King extends AbstractPiece {
	private BitSet checkBitSet;

	public King(Color color) {
		this(color, -1, -1);
	}

	public King(Color color, int curX, int curY) {
		super(color, curX, curY);
		checkBitSet = new BitSet(9);
	}

	public boolean isValidMove(Piece[][] board, int nextX, int nextY) {
		boolean valid = false;
		Piece nextSpot = board[nextX][nextY];
		if (nextSpot == null || nextSpot.getColor() != getColor()) {
			if ((Math.abs(nextX - curX) <= 1 && Math.abs(nextY - curY) <= 1)) {
				valid = true;
			}
		}
		return valid;
	}

	public void reinitializeCheckBitSet(Piece[][] board) {
		checkBitSet = new BitSet(9);
		int rowStart = Math.max(curX - 1, 0);
		int rowEnd = Math.min(curX + 1, 7);
		int colStart = Math.max(curY - 1, 0);
		int colEnd = Math.min(curY + 1, 7);
		for (int row = rowStart; row <= rowEnd; row++) {
			for (int col = colStart; col <= colEnd; col++) {
				Piece piece = board[row][col];
				if (piece == null || piece.getColor() != this.color) {
					int gridX = row - curX + 1;
					int gridY = col - curY + 1;
					int bitNumber = gridX * 3 + gridY % 3;
					checkBitSet.set(bitNumber);
				}
			}
		}
	}

	public BitSet getCheckBitSet() {
		return checkBitSet;
	}

	@Override
	public String toString() {
		return ("K" + (color == Color.WHITE ? "w" : "b"));
	}
}
