package chess;

public class Rook extends AbstractPiece {

	public Rook(Color color, int curX, int curY) {
		super(color, curX, curY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Piece[][] board, int nextX, int nextY) {
		boolean valid = false;
		Piece nextSpot = board[nextX][nextY];
		if (nextSpot == null || nextSpot.getColor() != getColor()) {
			if (curX == nextX) {
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
		return ("R" + (color == Color.WHITE ? "w" : "b"));
	}
}
