package chess;

public interface Piece {
	Color getColor();

	int getCurrentX();

	void setCurrentX(int x);

	int getCurrentY();

	void setCurrentY(int y);

	boolean isValidMove(Piece[][] board, int nextX, int nextY);

	boolean attackingKing(Piece[][] board, King king);
	
	boolean canSaveKing(Piece[][] board, King king, Piece attackingPiece);
}
