package game;

import java.util.Currency;

public class Board {

	//private int heroX, heroY;
	private Hero hero;
	
	private final int numCols;
	private final int numLines;
	
	public Board(int numCols, int numLines) 
	{
		this.numCols = numCols;
		this.numLines = numLines;
		
		// posicionar o actor
		//heroX = numCols/2;
		//heroY = numLines/2;
		hero = new Hero(numCols/2, numLines/2);
	}
	
	private int getNumCols()  { return this.numCols; }
	private int getNumLines() { return this.numLines; }
	
	public void show() 
	{
		// Desenhar a primeira linha
		System.out.print('+');
		for (int x = 0; x < this.getNumCols(); x++) System.out.print('-');
		System.out.println('+');
		
		// Desenhar as linhas do meio
		for (int y = 0; y < this.getNumLines(); y++) {
			System.out.print('|');
			for (int x = 0; x < this.getNumCols(); x++)
			{
				char currentElementChar = ' ';
				if(hero.isInPosition(x, y))
					currentElementChar = hero.toSymbol();
				
				System.out.print(currentElementChar);
			}
			System.out.println('|');
		}
		
		// Desenhar a última linha
		System.out.print('+');
		for (int x = 0; x < this.getNumCols(); x++) System.out.print('-');
		System.out.println('+');
	}

	public void translateActor(int x, int y) {
		hero.setDirection(x, y);
		hero.step();
	}
}
