import game.Board;
import game.Game;
import game.Input;

import java.util.Scanner;


public class App {

	public static void main(String[] args) {

		Game game = new Game();
		
		game.loadLevel(1);
		game.run();
				
	}

}
