package game;

import console.GraphConsole;

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
		GraphConsole.gotoXY(0, 0);
		
		// Desenhar a primeira linha
		GraphConsole.write("+");
		for (int x = 0; x < this.getNumCols(); x++) GraphConsole.write("-");
		GraphConsole.write("+");
		
		// Desenhar as linhas do meio
		for (int y = 0; y < this.getNumLines(); y++) {
			GraphConsole.gotoXY(0, y+1);
			GraphConsole.write("|");
			for (int x = 0; x < this.getNumCols(); x++)
			{
				char currentElementChar = ' ';
				if(hero.isInPosition(x, y))
					currentElementChar = hero.toSymbol();
				
				GraphConsole.write("" + currentElementChar);
			}
			GraphConsole.write("|");
		}
		
		// Desenhar a última linha
		GraphConsole.gotoXY(0, numLines+1);
		GraphConsole.write("+");
		for (int x = 0; x < this.getNumCols(); x++) GraphConsole.write("-");
		GraphConsole.write("+");
	}

	public void translateActor(int x, int y) {
		hero.setDirection(x, y);
		hero.step();
	}
}
