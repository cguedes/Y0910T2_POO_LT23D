package game;

import game.actors.Actor;
import common.Point;
import console.GraphConsole;

public class Board implements BoundaryProvider {

	private final int numCols;
	private final int numLines;
	
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
			 " Score: " 
	};
	
	/**
	 * Construção de um tabuleiro 
	 * 
	 * @param numCols número de colunas do tabuleiro
	 * @param numLines número de linhas do tabuleiro
	 */
	public Board(int numCols, int numLines) {
		this.numCols = numCols;
		this.numLines = numLines;
		this.statusMessage = "";
	}
	
	public double getNumCols()  {
		return numCols;
	}
	public double getNumLines() {
		return numLines;
	}

	// ########################################################################
	// Double-Buffering  
	// ########################################################################
	private static final int BOARD_WIDTH = 80; 
	private static final int BOARD_HEIGHT = 25; 
	private static final char DEFAULT_BUFFER_SYMBOL = ' ';
	private static final int DEFAULT_BUFFER_FORECOLOR = GraphConsole.FOREGROUND_WHITE; 
	
	private class Buffer {
		private char[][] symbols = new char[BOARD_WIDTH][BOARD_HEIGHT];
		private int[][]  colors  = new int[BOARD_WIDTH][BOARD_HEIGHT];
		
		public Buffer() {
			for (int i = 0; i < ~symbols.length; i++) {
				for (int j = 0; j < symbols[i].length; j++) {
					symbols[i][j] = DEFAULT_BUFFER_SYMBOL;
					colors[i][j] = DEFAULT_BUFFER_FORECOLOR;
				}
			}
		}

		public void set(int x, int y, char symbol, int foreColor) {
			symbols[x][y] = symbol;
			colors[x][y] = foreColor;
		}

		public char getSymbol(int x, int y) {
			return symbols[x][y];
		}

		public int getColor(int x, int y) {
			return colors[x][y];
		}
		
	}
	
	// Dois buffers com as dimensões da Consola
	private Buffer[] buffers = { new Buffer(), new Buffer() };
	private int currentBuffer = 0, otherBuffer = 1;
	
	private void writeAt(int x, int y, char c, int foreColor) {
		buffers[currentBuffer].set(x, y, c, foreColor);
	}

	private void writeAt(int x, int y, String str, int foreColor) {
		for (int i = 0; i < str.length(); i++) {
			writeAt(x+i, y, str.charAt(i), foreColor);
		}
	}

	private void swapBuffers() { 
		otherBuffer = currentBuffer;
		currentBuffer = (currentBuffer+1)%2; 
	}

	private void drawCurrentBuffer() {
		
		for (int x = 0; x < BOARD_WIDTH; x++) {
			for (int y = 0; y < BOARD_HEIGHT; y++) 
			{
				char otherSymbol   = buffers[otherBuffer].getSymbol(x, y);
				char currentSymbol = buffers[currentBuffer].getSymbol(x, y);

				int otherForeColor = buffers[otherBuffer].getColor(x, y);
				int currentForeColor = buffers[currentBuffer].getColor(x, y);
				
				if(currentSymbol != otherSymbol || currentForeColor != otherForeColor) 
				{
					GraphConsole.setForegroundColor(currentForeColor);
					GraphConsole.writeAt(x, y, "" + currentSymbol);
				}
			}
		}	
		swapBuffers();
	}
	
	// ########################################################################
	// Desenho  
	// ########################################################################
	public void draw() 
	{
		writeArenaAndOptionsToBuffer();
		writeStatusToBuffer();
		writePointsToBuffer();
		
		drawCurrentBuffer();
		
		moveCursorToStatus();
	}
	
	public void clear() {
		// Apagar o conteúdo da arena (área de jogo), status e pontuação
		for(int x = 0; x < numCols; ++x) 
			for(int y = 0; y < numLines; ++y)
				writeIntoArenaAt(x, y, ' ', GraphConsole.FOREGROUND_WHITE);
		
	}


	public void writeActor(Actor actor) {
		
		char actorSymbol = actor.toSymbol();
		int actorColor = GraphConsole.FOREGROUND_WHITE; //actor.getForeColor();
		Point actorPosition = actor.getPosition();

		writeIntoArenaAt((int)actorPosition.x, (int)actorPosition.y, actorSymbol, actorColor);
	}
	
	public void writeIntoArenaAt(int x, int y, char c, int foreColor) {
		int arenaDx = 1, arenaDy = 1;
		writeAt(x + arenaDy, y + arenaDx, "" + c, foreColor);
	}

	private void writeArenaAndOptionsToBuffer() {
		
		// Desenhar a primeira e última linhas (+--------+)
		int x = 0, y = 0;
		int foreColor = GraphConsole.FOREGROUND_GREEN | GraphConsole.FOREGROUND_INTENSITY; 
		writeAt(x, y, '+', foreColor);
		for (x = 1; x <= numCols; x++) writeAt(x, y, '-', foreColor);
		writeAt(x, y, '+', foreColor);

		// Desenhar a última linha (+--------+)
		x = 0; y = numLines + 1;
		writeAt(x, y, '+', foreColor);
		for (x = 1; x <= numCols; x++) writeAt(x, y, '-', foreColor);
		writeAt(x, y, '+', foreColor);

		// Desenhar as colunas
		for(int l = 0; l < numLines; l++) {
			writeAt(0, 1+l, '|', foreColor);
			writeAt(numCols+1, 1+l, '|', foreColor);
		}
				
		// Desenhar o HELP
		for(int h = 0; h < BOARD_HELP.length; ++h) {
			writeAt(numCols + 2, 1+h, BOARD_HELP[h], GraphConsole.FOREGROUND_WHITE);
		}
	}

	public void moveCursorToStatus() {
		GraphConsole.gotoXY(0, numLines+2);
	}
	
	// ########################################################################
	// Status  
	// ########################################################################
	private String statusMessage;

	public void setStatus(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	private void writeStatusToBuffer() {
		int statusX = 0, statusY = numLines + 2;
		int statusForeColor = GraphConsole.FOREGROUND_RED | GraphConsole.FOREGROUND_GREEN | GraphConsole.FOREGROUND_INTENSITY;
		// Apagar a mensagem de status
		writeAt(statusX, statusY, "                                                                      ", statusForeColor);
		
		// Escrever a mensagem de status
		writeAt(statusX, statusY, statusMessage, statusForeColor);
	}


	// ########################################################################
	// BoundaryProvider Implementation  
	// ########################################################################
	@Override
	public boolean isInside(Point pos) {
		return pos.x >= 0 && pos.y >= 0 && 
			   pos.x < numCols && pos.y < numLines;
	}

	// ########################################################################
	// Pontuation
	// ########################################################################
	private int points;
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	private void writePointsToBuffer() {
		int pointsX = numCols + BOARD_HELP[BOARD_HELP.length-1].length() + 2,
			pointsY = BOARD_HELP.length;
		writeAt(pointsX, pointsY, "" + points, GraphConsole.FOREGROUND_RED | GraphConsole.FOREGROUND_GREEN | GraphConsole.FOREGROUND_INTENSITY);
	}
	
	
	
}
