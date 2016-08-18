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
		int kingX = king.getCurrentX();
		int kingY = king.getCurrentY();
		int rowStart = Math.max(kingX - 1, 0);
		int rowEnd = Math.min(kingX + 1, 7);
		int colStart = Math.max(kingY - 1, 0);
		int colEnd = Math.min(kingY + 1, 7);

		for (int row = rowStart; row <= rowEnd; row++) {
			for (int col = colStart; col <= colEnd; col++) {
				Piece piece = board[row][col];
				if (piece == null || piece.getColor() != king.getColor()
						|| piece == king) {
					// temporarily move king to this position
					board[row][col] = king;
					board[kingX][kingY] = null;
					if ((curX != row || curY != col) && isValidMove(board, row, col)) {
						int gridX = row - kingX + 1;
						int gridY = col - kingY + 1;
						int bitNumber = gridX * 3 + gridY % 3;
						king.getCheckBitSet().clear(bitNumber);
						if (row == kingX && col == kingY) {
							check = true;
						}
					}
					// move the king back to original position
					board[kingX][kingY] = king;
					board[row][col] = piece;
				}
			}
		}

		return check;
	}

	private boolean rookCanSave(Piece[][] board, King king, Piece attackingPiece) {
		int attackingX = attackingPiece.getCurrentX();
		int attackingY = attackingPiece.getCurrentY();
		int kingX = king.getCurrentX();
		int kingY = king.getCurrentY();
		boolean canSave = false;
		if (kingX == attackingX) {
			int blockingY = kingY;
			if (attackingY > kingY) {
				while (++blockingY <= attackingY) {
					if (isValidMove(board, attackingX, blockingY)) {
						canSave = true;
						break;
					}
				}
			} else {
				while (--blockingY >= attackingY) {
					if (isValidMove(board, attackingX, blockingY)) {
						canSave = true;
						break;
					}
				}
			}
		} else if (kingY == attackingY) {
			int blockingX = kingX;
			if (attackingX > king.getCurrentX()) {
				while (++blockingX <= attackingX) {
					if (isValidMove(board, blockingX, attackingY)) {
						canSave = true;
						break;
					}
				}
			} else {
				while (--blockingX >= attackingX) {
					if (isValidMove(board, blockingX, attackingX)) {
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
		int attackingX = attackingPiece.getCurrentX();
		int attackingY = attackingPiece.getCurrentY();
		int kingX = king.getCurrentX();
		int kingY = king.getCurrentY();
		boolean canSave = false;

		if (Math.abs(attackingX - kingX) == Math.abs(attackingY - kingY)) {
			int blockingX = kingX;
			int blockingY = kingY;
			if (attackingX > kingX && attackingY > kingY) {
				while (++blockingX <= attackingX && ++blockingY <= attackingY) {
					if (isValidMove(board, blockingX, blockingY)) {
						canSave = true;
						break;
					}
				}
			} else if (attackingX > kingX && attackingY < kingY) {
				while (++blockingX <= attackingX && --blockingY >= attackingY) {
					if (isValidMove(board, blockingX, blockingY)) {
						canSave = true;
						break;
					}
				}
			} else if (attackingX < kingX && attackingY < kingY) {
				while (--blockingX >= attackingX && --blockingY >= attackingY) {
					if (isValidMove(board, blockingX, blockingY)) {
						canSave = true;
						break;
					}
				}
			} else if (attackingX < kingX && attackingY > kingY) {
				while (--blockingX >= attackingX && ++blockingY <= attackingY) {
					if (isValidMove(board, blockingX, blockingY)) {
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
