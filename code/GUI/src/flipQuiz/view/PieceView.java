package flipQuiz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import flipQuiz.model.FlipQuizModel;
import flipQuiz.model.Piece;

public class PieceView extends JLabel
{
	private final Piece piece;
	private final FlipQuizModel model;

	public PieceView(Piece piece, FlipQuizModel model) 
	{
		this.piece = piece;
		this.model = model;
		
		setBorder(new LineBorder(Color.BLACK));
		setHorizontalAlignment(CENTER);
		setPreferredSize(new Dimension(130, 130));
		setFont( new Font("Verdana", Font.BOLD, 30) );
		
		// Register Click Listener
		addMouseListener( new MouseAdapter() { 
			@Override
			public void mouseClicked(MouseEvent me) 
			{
				PieceView.this.model.playAt(PieceView.this.piece);
			}
		});
	}
	
	public void updatePiece()
	{
		if(piece.isSelected() || piece.isDiscovered()) 
		{
			URL resourceLocation = ClassLoader.getSystemResource(
														piece.getSymbol() + ".gif");
			Icon icon = new ImageIcon(resourceLocation);
			setIcon(icon);
		}
		else
		{
			setIcon(null);
		}
		
		if(piece.isDiscovered())
		{
			setBorder(new LineBorder(Color.GREEN, 4));
		}
		else
		{
			setBorder(new LineBorder(Color.BLACK));
		}
		
	}
		
}
