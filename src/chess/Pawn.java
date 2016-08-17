package chess;

public class Pawn extends AbstractPiece {

	public Pawn(Color color, int curX, int curY) {
		super(color, curX, curY);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isValidMove(Piece[][] board, int nextX, int nextY) {
		boolean isValid = false;
		Piece nextSpot = board[nextX][nextY];
		if (nextSpot == null || nextSpot.getColor() != getColor()) {
			if (((nextX == curX + 1 && color == Color.WHITE) || (nextX == curX - 1 && color == Color.BLACK))
					&& ((nextY == curY && board[nextX][nextY] == null) || ((nextY == curY + 1 || nextY == curY - 1)))) {
				isValid = true;
			}
		}
		return isValid;
	}

	@Override
	public String toString() {
		return ("P" + (color == Color.WHITE ? "w" : "b"));
	}
}
