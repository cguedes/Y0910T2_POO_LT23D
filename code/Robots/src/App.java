import game.Board;
import game.Input;

import java.util.Scanner;


public class App {

	public static void main(String[] args) {

		boolean gameOver = false;
		Scanner scanner = new Scanner(System.in);
		
		Board board = new Board(60, 22);
		board.show();
		
		Input input = new Input();
		
		do 
		{
			// Update game
			input.update();
			
			if( input.isKeyDown('a') )
				board.translateActor(-1,  0);
			
			if( input.isKeyDown('s') )
				board.translateActor( 0, +1);

			if( input.isKeyDown('d') )
				board.translateActor(+1,  0);

			if( input.isKeyDown('w') )
				board.translateActor( 0, -1);

			if( input.isKeyDown('x') )
				gameOver = true;

			// draw game
			board.show();
			
		} while(!gameOver);
		
		System.out.println("FIM");
				
	}

}
