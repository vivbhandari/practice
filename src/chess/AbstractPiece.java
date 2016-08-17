package chess;

public abstract class AbstractPiece implements Piece {
	protected Color color;
	protected int curX;
	protected int curY;

	public AbstractPiece(Color color, int curX, int curY) {
		super();
		this.color = color;
		this.curX = curX;
		this.curY = curY;
	}

	public Color getColor() {
		return color;
	}

	public int getCurrentX() {
		return curX;
	}

	public void setCurrentX(int x) {
		curX = x;
	}

	public int getCurrentY() {
		return curY;
	}

	public void setCurrentY(int y) {
		curY = y;
	}

	@Override
	public boolean attackingKing(Piece[][] board, King king) {
		boolean check = false;
		int rowStart = Math.max(king.getCurrentX() - 1, 0);
		int rowEnd = Math.min(king.getCurrentX() + 1, 7);
		int colStart = Math.max(king.getCurrentY() - 1, 0);
		int colEnd = Math.min(king.getCurrentY() + 1, 7);

		for (int row = rowStart; row <= rowEnd; row++) {
			for (int col = colStart; col <= colEnd; col++) {
				// temporarily move king to this position 
				Piece piece = board[row][col];
				board[row][col] = king;
				board[king.getCurrentX()][king.getCurrentY()] = null;
				if (isValidMove(board, row, col)) {
					int gridX = row - king.getCurrentX() + 1;
					int gridY = col - king.getCurrentY() + 1;
					int bitNumber = gridX * 3 + gridY % 3;
					king.getCheckBitSet().clear(bitNumber);
					if (row == king.getCurrentX() && col == king.getCurrentY()) {
						check = true;
					}
				}
				// move the king back to original position
				board[king.getCurrentX()][king.getCurrentY()] = king;
				board[row][col] = piece;
			}
		}

		return check;
	}

	private boolean rookCanSave(Piece[][] board, King king, Piece attackingPiece) {
		int nextX = attackingPiece.getCurrentX();
		int nextY = attackingPiece.getCurrentY();
		boolean canSave = false;
		if (king.getCurrentX() == nextX) {
			int i = king.getCurrentY();
			if (nextY > king.getCurrentY()) {
				while (++i <= nextY) {
					if (isValidMove(board, nextX, i)) {
						canSave = true;
						break;
					}
				}
			} else {
				while (--i >= nextY) {
					if (isValidMove(board, nextX, i)) {
						canSave = true;
						break;
					}
				}
			}
		} else if (king.getCurrentY() == nextY) {
			int i = king.getCurrentX();
			if (nextX > king.getCurrentX()) {
				while (++i <= nextX) {
					if (isValidMove(board, i, nextY)) {
						canSave = true;
						break;
					}
				}
			} else {
				while (--i >= nextX) {
					if (isValidMove(board, i, nextX)) {
						canSave = true;
						break;
					}
				}
			}
		}
		return canSave;
	}

	private boolean bishopCanSave(Piece[][] board, King king,
			Piece attackingPiece) {
		int nextX = attackingPiece.getCurrentX();
		int nextY = attackingPiece.getCurrentY();
		boolean canSave = false;

		if (Math.abs(nextX - king.getCurrentX()) == Math.abs(nextY
				- king.getCurrentY())) {
			int i = curX;
			int j = curY;
			if (nextX > curX && nextY > curY) {
				while (++i <= nextX && ++j <= nextY) {
					if (isValidMove(board, i, j)) {
						canSave = true;
						break;
					}
				}
			} else if (nextX > curX && nextY < curY) {
				while (++i <= nextX && --j >= nextY) {
					if (isValidMove(board, i, j)) {
						canSave = true;
						break;
					}
				}
			} else if (nextX < curX && nextY < curY) {
				while (--i >= nextX && --j >= nextY) {
					if (isValidMove(board, i, j)) {
						canSave = true;
						break;
					}
				}
			} else if (nextX < curX && nextY > curY) {
				while (--i >= nextX && ++j <= nextY) {
					if (isValidMove(board, i, j)) {
						canSave = true;
						break;
					}
				}
			}
		}
		return canSave;
	}

	@Override
	public boolean canSaveKing(Piece[][] board, King king, Piece attackingPiece) {
		boolean canSave = false;
		if (attackingPiece instanceof Rook) {
			canSave = rookCanSave(board, king, attackingPiece);
		} else if (attackingPiece instanceof Bishop) {
			canSave = bishopCanSave(board, king, attackingPiece);
		} else if (attackingPiece instanceof Knight
				|| attackingPiece instanceof Pawn) {
			if (isValidMove(board, attackingPiece.getCurrentX(),
					attackingPiece.getCurrentY())) {
				canSave = true;
			}
		} else if (attackingPiece instanceof Queen) {
			canSave = rookCanSave(board, king, attackingPiece)
					|| bishopCanSave(board, king, attackingPiece);
		}
		return canSave;
	}
}
