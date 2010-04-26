package game;

import game.actors.Actor;
import game.actors.Hero;
import game.actors.Robot;
import common.Point;

public class Game {

	// ############################################################
	// Gestão da existência de apenas uma instância de Jogo 
	// ############################################################
	private static Game gameSingleInstance = null;
	
	public static Game getInstance() {
		return gameSingleInstance;
	}
	
	public Game() {
		// Definir a única instância de Jogo
		gameSingleInstance = this;
		
		// TODO: Gerar ERRO quando chamarem duas vezes este construtor.
		//       Lançar excepção.
	}
	
	// ############################################################
	// Gestão do teclado (input)
	// ############################################################
	private Input input;
	public Input getInput() { return input; }
	
	// ############################################################
	// Estado do jogo
	// ############################################################
	private boolean gameOver;
	private Board board;
	private Actor[] actors;
	
	private static final int NUM_COLS = 60;
	private static final int NUM_LINES = 22;

	// ############################################################
	// Suporte para existência de níveis
	// ############################################################
	public void loadLevel(int numLevel) {
		gameOver = false;
		
		board = new Board(NUM_COLS, NUM_LINES);
		input = new Input();
		
		// Criar actores
		int numRobots = numLevel * 10 + numLevel / 2;
		actors = new Actor[numRobots + 1];
		int numActors = 0;
		
		// Adicionar o Hero
		Point pos = new Point(getRandomPosition());
		Hero hero = new Hero(pos);
		hero.setBoundaryProvider(board);
		
		for(int i = 0; i < numRobots; ++i) {
			Robot robot = new Robot(getRandomPosition(), hero);
			robot.setBoundaryProvider(board);
			actors[numActors++] = robot;
		}

		actors[numActors++] = hero;
	}
	
	public Point getRandomPosition() {
		Point p = new Point();
		p.x = (int)(Math.random() * NUM_COLS);
		p.y = (int)(Math.random() * NUM_LINES);
		return p;
	}

	// ############################################################
	// ciclo principal do jogo
	// ############################################################
	public void run() {
		
		// mostrar o tabuleiro (ínicio da aplicação)
		drawGame();
		
		// Update game
		do 
		{
			// Actualiza o input
			// fica bolqueado à espera de tecla (down)
			input.update();
			
			// Actualizar todos os actores do jogo
			updateGame();
			
			// mostrar todos os actores do jogo
			drawGame();
			
			// Detectar fim (explicito) de jogo
			if( input.isKeyDown('x') )
				gameOver = true;

		} while(!gameOver);
		
	}

	private void updateGame() {
		for (int i = 0; i < actors.length; i++) {
			actors[i].update();
		}
	}

	private void drawGame() {
		board.clear();
		
		for (int i = 0; i < actors.length; i++) {
			board.writeActor(actors[i]);
		}

		board.draw();
	}

	// ############################################################
	// Colisão 
	// ############################################################
	public void checkCollision(Actor actor) {
		
		System.out.println("check collision....." + actor.toSymbol());
		System.out.println("pos = " + actor.getPosition());
		
		for (int i = 0; i < actors.length; i++) {
			Actor otherActor = actors[i];
			if(actor != otherActor) {
				Point actorPosition      = actor.getPosition();
				Point otherActorPosition = otherActor.getPosition();
				
				if( actorPosition.equals(otherActorPosition) )
				{
					// O actor colide com o outro (variável de iteração do ciclo)
					actor.collide(otherActor);
					otherActor.collide(actor);
				}
			}
		}
		
		
	}
	
	
	
}
