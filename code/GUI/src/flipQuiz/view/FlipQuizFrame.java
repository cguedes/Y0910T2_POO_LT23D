package flipQuiz.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import flipQuiz.model.Game;

public class FlipQuizFrame extends JFrame
{
	private final Game game;

	private JLabel lblTurns;
	
	public FlipQuizFrame(Game game) 
	{
		// Guardar o modelo
		this.game = game;

		// criar a UI
		this.setLayout(new BorderLayout());
		//   ---> Titulo
		this.add( new JLabel("Flip Game"), BorderLayout.NORTH );
		
		//   ---> Grelha com peças
		FlipQuizGrid grid = new FlipQuizGrid(game);
		this.add(grid, BorderLayout.CENTER);
		
		//   ---> Status
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.add( new JLabel("Turns: ") );
		lblTurns = new JLabel("0");
		statusPanel.add( lblTurns );
		this.add(statusPanel, BorderLayout.SOUTH );
		
		this.pack();
		
	}

}
