package flipQuiz.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import flipQuiz.model.FlipQuizModel;
import flipQuiz.model.GameListener;
import flipQuiz.model.Piece;

public class FlipQuizFrame extends JFrame implements GameListener
{
	private JLabel lblNumMoves;
	private FlipQuizGrid grid;
	private FlipQuizModel model;
	
	public FlipQuizFrame() {
		this(new FlipQuizModel(4, 6));
	}
	
	public FlipQuizFrame(FlipQuizModel _model) 
	{
		this.model = _model;
		
		// setup UI -----------------------------------------------------------
		this.setLayout(new BorderLayout());
		
		//   --> Title
		JLabel title = new JLabel("Flip Quiz");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Verdana", Font.BOLD, 40) );
		title.setForeground(Color.RED);
		this.add( title, BorderLayout.NORTH );
		
		//   --> Grid
		grid = new FlipQuizGrid(model); 
		this.add( grid, BorderLayout.CENTER );
		
		//   --> status panel 
		JPanel statusPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
		lblNumMoves = new JLabel("0");
		statusPane.add( new JLabel("Jogadas: ") );
		statusPane.add( lblNumMoves );
		this.add( statusPane, BorderLayout.SOUTH );
		
		
		// Menu
		JMenuBar menuBar = new JMenuBar();
		//   --> gameMenu
		JMenu gameMenu = new JMenu("Game");
		gameMenu.setMnemonic('G');
		JMenuItem menuNew = new JMenuItem("New", KeyEvent.VK_N);
		menuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		menuNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		gameMenu.add(menuNew);
		gameMenu.addSeparator();
		final JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_X);
		menuExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		gameMenu.add(menuExit);

		//   --> HelpMenu
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		JMenuItem menuAbout = new JMenuItem("About");
		menuAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		helpMenu.add(menuAbout);
		
		helpMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO
			}
		});
		
		menuBar.add(gameMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
		
		// Game Listener
		model.addGameListener(this);
		
		// pack ---------------------------------------------------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}

	protected void newGame() 
	{
		model.restart(); 
	}

	@Override
	public void pairFormed(Piece first, Piece second) { 	}

	@Override
	public void pieceUpdated(Piece piece) { }

	@Override
	public void turnChanged(int turn) 
	{
		lblNumMoves.setText("" + turn);
	}
	
	
}
