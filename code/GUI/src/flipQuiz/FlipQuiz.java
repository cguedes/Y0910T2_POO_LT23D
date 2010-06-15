package flipQuiz;

import javax.swing.JFrame;

import flipQuiz.model.FlipQuizModel;
import flipQuiz.view.FlipQuizFrame;


public class FlipQuiz 
{

	public static void main(String[] args) 
	{
		FlipQuizModel model = new FlipQuizModel(4, 6);
		
		JFrame frame = new FlipQuizFrame(model);
		frame.setVisible(true);

		// Uncomment to show two frames
		//JFrame frame2 = new FlipQuizFrame(model);
		//frame2.setVisible(true);

	}

}
