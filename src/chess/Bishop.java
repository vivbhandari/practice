package chess;

public class Bishop extends AbstractPiece {

	public Bishop(Color color, int curX, int curY) {
		super(color, curX, curY);
	}

	@Override
	public boolean isValidMove(Piece[][] board, int nextX, int nextY) {
		boolean valid = false;
		Piece nextSpot = board[nextX][nextY];
		if (nextSpot == null || nextSpot.getColor() != getColor()) {
			if (Math.abs(nextX - curX) == Math.abs(nextY - curY)) {
				int i = curX;
				int j = curY;
				if (nextX > curX && nextY > curY) {
					while (++i < nextX && ++j < nextY && board[i][j] == null)
						;
				} else if (nextX > curX && nextY < curY) {
					while (++i < nextX && --j > nextY && board[i][j] == null)
						;
				} else if (nextX < curX && nextY < curY) {
					while (--i > nextX && --j > nextY && board[i][j] == null)
						;
				} else if (nextX < curX && nextY > curY) {
					while (--i > nextX && ++j < nextY && board[i][j] == null)
						;
				}
				if (i == nextX)
					valid = true;
			}
		}
		return valid;
	}

	@Override
	public String toString() {
		return ("B" + (color == Color.WHITE ? "w" : "b"));
	}
}
