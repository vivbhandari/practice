package chess;

public class Knight extends AbstractPiece {

	public Knight(Color color, int curX, int curY) {
		super(color, curX, curY);
	}

	public boolean isValidMove(Piece[][] board, int nextX, int nextY) {
		boolean valid = false;
		Piece nextSpot = board[nextX][nextY];
		if (nextSpot == null || nextSpot.getColor() != getColor()) {
			if ((Math.abs(nextX - curX) == 2 && Math.abs(nextY - curY) == 1)
					|| (Math.abs(nextX - curX) == 1 && Math.abs(nextY - curY) == 2))
				valid = true;
		}
		return valid;
	}

	@Override
	public String toString() {
		return ("N" + (color == Color.WHITE ? "w" : "b"));
	}
}
