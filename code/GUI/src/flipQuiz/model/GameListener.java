package flipQuiz.model;

public interface GameListener 
{
	void pieceUpdated(Piece piece);
	void pairFormed(Piece first, Piece second);
	void turnChanged(int turn);
}
