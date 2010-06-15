package flipQuiz.model;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

public class FlipQuizModel 
{

	private final int nRows;
	private final int nCols;
	
	private Piece[][] pieces;
	
	private int turnNumber;
	
	private Timer timer;

	public FlipQuizModel(int nRows, int nCols) 
	{
		this.nRows = nRows;
		this.nCols = nCols;
		this.pieces = new Piece[nRows][nCols];
		this.setTurnNumber(0);
		
		// Sets the timer
		timer = new Timer(500, new TimerListener());
		timer.setRepeats(false);

		// verify if the nRows * nCols are valid (result must be even)
		if( (nRows * nCols) % 2.0 != 0 )
			throw new UnsupportedOperationException("[nRows * nCols] must be an even value");
		
		// create board
		for(int r = 0; r < nRows; ++r)
			for(int c = 0; c < nCols; ++c)
				pieces[r][c] = new Piece(new Point(c, r));
		
		buildBoard();
		
	}
	
	private void buildBoard()
	{
		// fill pieces
		//  --> Add no an collection all the eligible points
		List<Point> allPoints = new ArrayList<Point>(nRows * nCols);
		for(int r = 0; r < nRows; ++r)
			for(int c = 0; c < nCols; ++c)
				allPoints.add( new Point(c, r) );
		
		int allPointsSize = allPoints.size();
		
		int numPairs = (nRows * nCols) / 2;
		char symbol = 'A';
		while(numPairs > 0)
		{
			// First piece
			Point point1 = getRandomPoint(allPoints, allPointsSize--);
			Piece piece1 = get(point1.y, point1.x);
			piece1.setSymbol(symbol);
			
			// Second piece
			Point point2 = getRandomPoint(allPoints, allPointsSize--);
			Piece piece2 = get(point2.y, point2.x);
			piece2.setSymbol(symbol);

			--numPairs;
			symbol += 1;

			// Hack: There are only 5 piece images
			if(symbol == 'F') 
				symbol = 'A';
		}
		
	}
	
	private Point getRandomPoint(List<Point> allPoints, int effectiveSize) {

		int randIdx = (int)(Math.random() * effectiveSize);
		Point res = allPoints.get(randIdx);
		
		allPoints.set(randIdx, null);

		// Move the last effective point of the list to the returned position
		if(effectiveSize > 0 && randIdx < effectiveSize - 1)
			allPoints.set( randIdx, allPoints.get(effectiveSize - 1) );
		
		return res;
	}

	public void restart() {
		
		// Reset number of turns
		turnNumber = 0;
		onNumberOfTurnsChanged();
		
		// rebuild the board
		buildBoard();
		
		// notify piece changes
		for(int r = 0; r < nRows; ++r)
			for(int c = 0; c < nCols; ++c)
				onPieceUpdate( pieces[r][c] );
		
		// clear selection state
		resetSelection();
		
	}

	public int getNumRows() { return nRows; }
	public int getNumCols() { return nCols; }
	
	public Piece get(int r, int c)          { return pieces[r][c]; }
	public void set(int r, int c, Piece p)  { pieces[r][c] = p;    }

	
	private Piece firstPiece = null;
	private Piece secondPiece = null;
	
	public void playAt(Piece piece) 
	{
		if(piece.isDiscovered() || piece.isSelected() || timer.isRunning()) 
			return;
		
		// Check if is the first or the second piece
		if(firstPiece == null)
		{
			// Register the piece as first piece
			firstPiece = piece;
			firstPiece.setSelected(true);
			
			onPieceUpdate(firstPiece);
			
		}
		else
		{
			secondPiece = piece;
			secondPiece.setSelected(true);
			onPieceUpdate(secondPiece);
			
			timer.start();
		}
				
	} 
	
	private void resetSelection() {
		firstPiece = secondPiece = null;
	}

	
	// лллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл	
	// ╗╗╗╗╗╗ Events лллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл
	// лллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл	
	Collection<GameListener> gameListeners = new LinkedList<GameListener>();
	
	public void addGameListener(GameListener gameListener)
	{
		gameListeners.add(gameListener);
	}
	
	private void onPieceUpdate(Piece piece) 
	{
		for(GameListener gl: gameListeners)
		{
			gl.pieceUpdated(piece);
		}
	}
	
	public void onNumberOfTurnsChanged() 
	{
		for(GameListener gl: gameListeners)
		{
			gl.turnChanged(getTurnNumber());
		}
	}
	
	public void onPair(Piece first, Piece second)
	{
		for(GameListener gl: gameListeners)
		{
			gl.pairFormed(first, second);
		}
	}

	// лллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл	
	// лллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллллл	
	
	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	private class TimerListener implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			if(firstPiece.equals(secondPiece))
			{
				// Equal pieces :-)
				firstPiece.setDiscovered(true);
				secondPiece.setDiscovered(true);
			}
			else
			{
				firstPiece.setSelected(false);
				secondPiece.setSelected(false);
			}

			onPieceUpdate(firstPiece);
			onPieceUpdate(secondPiece);
			
			onPair(firstPiece, secondPiece);

			// Reset first/second piece
			resetSelection();

			setTurnNumber(getTurnNumber() + 1);
			onNumberOfTurnsChanged();
			
		}

	}



}
