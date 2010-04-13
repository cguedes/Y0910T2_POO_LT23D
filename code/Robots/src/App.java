import game.Board;

import java.util.Scanner;


public class App {

	public static void main(String[] args) {

		boolean gameOver = false;
		Scanner scanner = new Scanner(System.in);
		
		Board board = new Board(60, 22);
		board.show();
		
		//board.moveActor(1, 0);
		
		do {
			char key = scanner.nextLine().charAt(0);
			
			switch(key)
			{
				case 'a': board.translateActor(-1,  0); break;
				case 'd': board.translateActor(+1,  0); break;
				case 's': board.translateActor( 0, +1); break;
				case 'w': board.translateActor( 0, -1); break;
				case 'x': gameOver = true; break;
			}
			board.show();
			
		} while(!gameOver);
		System.out.println("FIM");
				
	}

}
