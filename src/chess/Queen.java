package chess;

public class Queen extends AbstractPiece {

	public Queen(Color color, int curX, int curY) {
		super(color, curX, curY);
		// TODO Auto-generated constructor stub
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
			} else if (curX == nextX) {
				int i = curY;
				if (nextY > curY) {
					while (++i < nextY && board[nextX][i] == null)
						;
				} else {
					while (--i > nextY && board[nextX][i] == null)
						;
				}
				if (i == nextY)
					valid = true;
			} else if (curY == nextY) {
				int i = curX;
				if (nextX > curX) {
					while (++i < nextX && board[i][nextY] == null)
						;
				} else {
					while (--i > nextX && board[i][nextY] == null)
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
		return ("Q" + (color == Color.WHITE ? "w" : "b"));
	}
}
