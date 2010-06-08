package flipQuiz.model;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

public class Game 
{

	private final int nRows;
	private final int nCols;
	
	private Piece[][] pieces;
	
	private int turnNumber;
	
	private Timer timer;

	public Game(int nRows, int nCols) 
	{
		this.nRows = nRows;
		this.nCols = nCols;
		this.pieces = new Piece[nRows][nCols];
		this.turnNumber = 0;
		
		// verify if the nRows * nCols are valid (result must be even)
		if( (nRows * nCols) % 2.0 != 0 )
			throw new UnsupportedOperationException("[nRows * nCols] must be an even value");
		
		// fill pieces
		//  --> Add no an collection all the eligible points
		List<Point> allPoints = new ArrayList<Point>(nRows * nCols);
		for(int r = 0; r < nRows; ++r)
			for(int c = 0; c < nCols; ++c)
				allPoints.add( new Point(c, r) );
		
		int numPairs = (nRows * nCols) / 2;
		char symbol = 'a';
		while(numPairs > 0)
		{
			// First piece
			int idx1 = (int)(Math.random() * allPoints.size());
			Point point1 = allPoints.remove(idx1);
			Piece piece1 = new Piece(symbol, point1);
			
			// Second piece
			int idx2 = (int)(Math.random() * allPoints.size());
			Point point2 = allPoints.remove(idx2);
			Piece piece2 = new Piece(symbol, point2);

			set(point1.y, point1.x, piece1);
			set(point2.y, point2.x, piece2);
			
			--numPairs;
			symbol += 1;
		}
		
	}

	public int getNumRows() { return nRows; }
	public int getNumCols() { return nCols; }
	
	public Piece get(int r, int c)          { return pieces[r][c]; }
	public void set(int r, int c, Piece p)  { pieces[r][c] = p;    }

	
	private Piece firstPiece = null;
	private Piece secondPiece = null;
	
	public void playAt(Piece piece) 
	{
		if(piece.isVisible() || firstPiece == piece) 
			return;
		
		// Check if is the first or the second piece
		if(firstPiece == null)
		{
			// Register the piece as first piece
			firstPiece = piece;
			firstPiece.setVisible(true);
		}
		else
		{
			// Register the second piece
			secondPiece = piece;
			secondPiece.setVisible(true);
			
			// Check if the pieces are equals
			if(firstPiece.equals(secondPiece))
			{
				// gerar evento a indicar que encontrei um par
			}
			else
			{
				// cancelar a selecção
				firstPiece.setVisible(false);
				secondPiece.setVisible(false);
				firstPiece = secondPiece = null;
			}
			
		}
				
	} 
	
}
