package flipQuiz.app;

import flipQuiz.model.Game;
import flipQuiz.view.FlipQuizFrame;

public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Game game = new Game(4, 5);

		FlipQuizFrame frame = new FlipQuizFrame(game);
		frame.setVisible(true);
		
		//FlipQuizFrameWithIcons frame2 = new FlipQuizFrameWithIcons(game);
		//frame2.setVisible(true);
		
	}

}
