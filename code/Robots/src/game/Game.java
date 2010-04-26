package game;

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
		int numRobots = 2; //numLevel * 10 + numLevel / 2;
		actors = new Actor[numRobots + 1];
		int numActors = 0;
		
		// Adicionar o Hero
		Point pos = new Point(20, 12); //getRandomPosition();
		Hero hero = new Hero(pos);
		hero.setBoundaryProvider(board);
		
		Robot robot = new Robot(new Point(7, 10), hero);
		robot.setBoundaryProvider(board);
		actors[numActors++] = robot;

		Robot robot2 = new Robot(new Point(5, 10), hero);
		robot2.setBoundaryProvider(board);
		actors[numActors++] = robot2;

		actors[numActors++] = hero;
		
		
	}
	
	private Point getRandomPosition() {
		Point p = new Point();
		p.x = Math.random() * NUM_COLS;
		p.y = Math.random() * NUM_LINES;
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
		board.drawFixedParts();
		
		for (int i = 0; i < actors.length; i++) {
			board.drawActor( actors[i] );
		}
		
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
					otherActor.collide(actor);
					actor.collide(otherActor);
				}
			}
		}
		
		
	}
	
	
	
}
