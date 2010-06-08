package flipQuiz.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import flipQuiz.model.Game;

public class FlipQuizGrid extends JPanel {

	private final Game game;

	public FlipQuizGrid(Game game) {
		this.game = game;
		
		this.setLayout(new GridLayout(2, 3));
		
		this.setOpaque(true);
		//this.setBackground(Color.RED);
		
		
		this.add(new JLabel(" a "));
		this.add(new JLabel(" b "));
		this.add(new JLabel(" c "));
		this.add(new JLabel(" d "));
		this.add(new JLabel(" e "));
		this.add(new JLabel(" f "));
		
		
	}

	
	
}
