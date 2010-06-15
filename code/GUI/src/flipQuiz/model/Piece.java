package flipQuiz.model;

import java.awt.Point;

public class Piece 
{
	private char symbol;
	private final Point position;
	private boolean isSelected;
	private boolean isDiscovered;

	public Piece(char symbol, Point position) 
	{
		this(position);
		
		this.setSymbol(symbol);
		
		isSelected = false;
		setDiscovered(false);
	}

	public Piece(Point position) {
		this.position = position;
	}

	public char getSymbol() 
	{
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
		setDiscovered(false);
	}

	public Point getPosition() 
	{
		return position;
	}

	public void setSelected(boolean isSelected) 
	{
		this.isSelected = isSelected;
	}

	public boolean isSelected() 
	{
		return isSelected;
	}
	
	public void setDiscovered(boolean isDiscovered) 
	{
		this.isDiscovered = isDiscovered;
		if(isDiscovered == false)
			setSelected(false);
	}

	public boolean isDiscovered() 
	{
		return isDiscovered;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if(obj == null || !(obj instanceof Piece))
			return false;
		
		Piece other = (Piece)obj;
		return this.symbol == other.symbol;
	}




	
}
