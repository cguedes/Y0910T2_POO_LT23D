package game;

import common.Point;
import console.GraphConsole;

public class Board implements BoundaryProvider {

	private final int numCols;
	private final int numLines;
	
	public Board(int numCols, int numLines) 
	{
		this.numCols = numCols;
		this.numLines = numLines;
	}
	
	private int getNumCols()  { return this.numCols; }
	private int getNumLines() { return this.numLines; }
	
	// ############################################################
	// Comportamento relativo aos limites do tabuleiro
	//  -> implementação do método da interface BoundaryProvider
	// ############################################################
	public boolean isInside(Point pos) {
		return pos.x >= 0 && pos.y >= 0 &&
		       pos.x < getNumCols() && pos.y < getNumLines();
	};
	
	// ############################################################
	// Apresentação
	//   -> parte fixa
	//   -> desenho de actores
	// ############################################################
	private final static String[] BOARD_HELP = {
		 " Directions:      ",  
		 "                  ",
		 "     w            ",  
		 "     |            ",  
		 "  a -+- d         ",  
		 "     |            ",  
		 "     s            ",  
		 "                  ",  
		 " Commands:        ",  
		 "  e: wait for end ",  
		 "  t: teleport     ",  
		 "  p: quit         ",  
		 "  c: redraw screen",  
		 "                  ",  
		 " Legend:          ",  
		 "  +: robot        ",  
		 "  *: junk heap    ",  
		 "  @: you          ",  
		 "  #: you died     ",  
		 "                  ",  
	};

	
	// Desenha as partes fixas do tabuleiro 
	//   -> Paredes
	//   -> Help
	//   -> ...
	public void drawFixedParts() 
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
			for (int x = 0; x < this.getNumCols(); x++) {
				GraphConsole.write(" ");
			}
			GraphConsole.write("|");
			
			if(y < BOARD_HELP.length) {
				GraphConsole.write(BOARD_HELP[y]);
			}
			
		}
		
		// Desenhar a última linha
		GraphConsole.gotoXY(0, numLines+1);
		GraphConsole.write("+");
		for (int x = 0; x < this.getNumCols(); x++) GraphConsole.write("-");
		GraphConsole.write("+");
	}

	public void drawActor(Actor hero) {
		// Obter as coordenadas (DO MUNDO) relativas ao heroi
		int x = (int)hero.getPosition().x;
		int y = (int)hero.getPosition().y;
		
		// Passar de coordenadas do mundo para coordenadas do ecra (arena)
		int arenaDx = 1; // deslocamento da arena em 
		int arenaDy = 1; // relação à consola
		x += arenaDx;
		y += arenaDy;
		
		char actorSymbol = hero.toSymbol();
		GraphConsole.writeAt(x, y, "" + actorSymbol);
	}

}
