package game;

import common.Point;

public class Hero extends Actor {

	// Construtor
	public Hero(Point initialPosition) {
		super(initialPosition, '@');
		
		this.direction = new Point(Point.STOPED);
	}

	// ############################################################
	// Deslocamento
	// ############################################################
	private final Point direction;
	public Point getDirection() { return direction; }
	
	// ############################################################
	// Actualização 
	// ############################################################
	public void update() {

		if(!isAlive()) return;
		
		direction.moveTo(Point.STOPED);
		Input input = Game.getInstance().getInput();
		if( input.isKeyDown('a') ) { direction.moveTo(Point.LEFT); }
		if( input.isKeyDown('s') ) { direction.moveTo(Point.DOWN); }
		if( input.isKeyDown('d') ) { direction.moveTo(Point.RIGHT); }
		if( input.isKeyDown('w') ) { direction.moveTo(Point.UP); }

		// Aqui sabemos que o Heroi tem a direcção definida
		//  -> falta fazer o movimento (código implementado em Actor!)
		super.update();
	}
	
	// ############################################################
	// Apresentação (aspecto gráfico)
	// ############################################################
	public char toSymbol() { 
		if(isAlive()) { return super.toSymbol(); }
		return '!'; 
	}

	// ############################################################
	// Colisão 
	// ############################################################
	public void collide(Actor actor) {
		
	}


}
