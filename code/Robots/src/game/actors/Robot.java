package game.actors;

import common.Point;

public class Robot extends Actor {

	private final Hero hero;

	// Construtor
	public Robot(Point initialPosition, Hero hero) {
		super(initialPosition, '+');
		this.hero = hero;
	}

	// ############################################################
	// Deslocamento
	// ############################################################
	public Point getDirection() { 
		if(!isAlive()) return Point.STOPED;
		
		// O robot está sempre virado para o heroi
		Point dif = Point.subtract(hero.getPosition(), getPosition() );
		
		Point absDif = new Point(dif);
		absDif.x = Math.abs(dif.x);
		absDif.y = Math.abs(dif.y);
		
		// Como o robot não anda na diagonal, move-se na direcção de menor valor (mais perto)
		boolean goHorizontal = absDif.x > absDif.y;
		
		if(goHorizontal) {
			dif.x = Math.signum(dif.x);
			dif.y = 0;
		} 
		else
		{
			// Caso contrário, move-se na vertical
			dif.x = 0;
			dif.y = Math.signum(dif.y);
		}
		
		return dif;
	}
	
	
	// ############################################################
	// Apresentação (aspecto gráfico)
	// ############################################################
	public char toSymbol() { 
		if(isAlive()) { return super.toSymbol(); }
		return '*'; 
	}

	// ############################################################
	// Colisão 
	// ############################################################
	public void collide(Actor actor) {
		
		if(actor instanceof Hero) {
			actor.die();
			return;
		}
		
		if(actor instanceof Robot) {
			actor.die();
			this.die();
		}
		
		
	}
	
}
