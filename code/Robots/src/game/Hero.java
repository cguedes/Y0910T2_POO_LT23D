package game;

public class Hero {

	// DADOS (coordenada no mundo)
	private int x, y;
	private int dx, dy;
	private char symbol;
	
	// Construtor
	public Hero(int x, int y) {
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
		this.symbol = '@';
	}
	
	public char toSymbol() { return symbol; }
	
	public boolean isInPosition(int xx, int yy) {
		if(this.x == xx && this.y == yy)
			return true;
		return false;
	}
	
	public void setDirection(int dx, int dy) {
		this.dx += dx;	// BUG!!!
		this.dy += dy;  // BUG!!!
	}
	
	public void step() {
		this.x += this.dx;
		this.y += this.dy;
	}

}
