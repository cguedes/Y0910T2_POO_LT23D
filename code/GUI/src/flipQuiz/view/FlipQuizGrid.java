package flipQuiz.view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import flipQuiz.model.FlipQuizModel;
import flipQuiz.model.GameListener;
import flipQuiz.model.Piece;

public class FlipQuizGrid extends JPanel implements GameListener
{

	private final FlipQuizModel model;
	private final PieceView[][] pieces;

	public FlipQuizGrid(FlipQuizModel model) 
	{
		this.model = model;
		
		pieces = new PieceView[model.getNumRows()][model.getNumCols()];
		
		// Setup UI -----------------------------------------------------------
		this.setLayout(new GridLayout(model.getNumRows(), model.getNumCols(), 2, 2));

		for(int r = 0; r < model.getNumRows(); ++r)
			for(int c = 0; c < model.getNumCols(); ++c)
			{
				Piece piece = model.get(r, c);
				PieceView pieceView = new PieceView(piece, model);
				
				this.add(pieceView);
				
				pieces[r][c] = pieceView;
			}
		
		
		model.addGameListener(this);
	}

	@Override
	public void pairFormed(Piece first, Piece second)
	{
		pieceUpdated(first);
		pieceUpdated(second);
	}

	@Override
	public void pieceUpdated(Piece piece) 
	{
		getPieceView(piece).updatePiece();
	}

	private PieceView getPieceView(Piece piece) {
		PieceView pv = pieces[piece.getPosition().y][piece.getPosition().x];
		return pv;
	}

	@Override
	public void turnChanged(int turn) 
	{
		// Nothing to do here
	}

}
