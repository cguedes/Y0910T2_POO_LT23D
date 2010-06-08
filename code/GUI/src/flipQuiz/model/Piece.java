package flipQuiz.model;

import java.awt.Point;

public class Piece 
{
	private final String symbol;
	private final Point position;
	private boolean isVisible;

	public Piece(char symbol, Point position) 
	{
		this.symbol = "" + symbol;
		this.position = position;
		this.setVisible(false);
	}

	public String getSymbol() 
	{
		return isVisible ? symbol : " ";
	}

	public Point getPosition() 
	{
		return position;
	}

	public void setVisible(boolean isVisible) 
	{
		this.isVisible = isVisible;
	}

	public boolean isVisible() 
	{
		return isVisible;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj == null || !(obj instanceof Piece))
			return false;
		
		Piece other = (Piece)obj;
		return this.symbol.equals(other.symbol);
	}
	
}
