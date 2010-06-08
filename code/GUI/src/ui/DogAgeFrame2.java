package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Inclui os elementos necessários à conversão 
// de idade do cão para idade do Humano
public class DogAgeFrame2 extends JFrame {

	
	private JTextField txtDogAge, txtHumanAge;
	
	
	public DogAgeFrame2() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tiny Window 2");
		
		// Reconfigurar o container desta janela de forma
		// que que o seu layout manager seja o FlowLayout
		Container container = this.getContentPane();
		LayoutManager layout = new FlowLayout(); //new BorderLayout();
		container.setLayout( layout );
		
		// Criação da label (bloco de texto)
		JLabel lblDogAge        = new JLabel("Dog Age: ");
		txtDogAge    			= new JTextField("10");
		JButton btnConvertAge   = new JButton("Convert");
		JLabel lblHumanAge      = new JLabel("Human Age: ");
		txtHumanAge  			= new JTextField();
		
		// Definir caracteristicas dos elementos gráficos
		txtDogAge.setPreferredSize(new Dimension(100, txtDogAge.getPreferredSize().height));
		txtHumanAge.setPreferredSize(new Dimension(100, txtDogAge.getPreferredSize().height));
		
		// Registar eventos
		//   -> Registar no "evento de clique" do botão
		ConvertButtonListener convertButtonListener = new ConvertButtonListener(); 
			//new ConvertButtonListener(txtDogAge, txtHumanAge);
		btnConvertAge.addActionListener( convertButtonListener );
		
		//   -> Registar no "evento de mouse" do botão
		ChangeColorMouseListener changeColorMouseListener = new ChangeColorMouseListener();
		btnConvertAge.addMouseListener(changeColorMouseListener);
		txtDogAge.addMouseListener(changeColorMouseListener);
		lblDogAge.setOpaque(true);
		lblDogAge.addMouseListener(changeColorMouseListener);
		
		
		// Adicionar a label à janela
		container.add(lblDogAge/*, BorderLayout.WEST*/);
		container.add(txtDogAge);
		container.add(btnConvertAge);
		container.add(lblHumanAge);
		container.add(txtHumanAge);
		
		// Ajustar a janela à dimensão necessária para apresentar
		// todos os seus componentes filho, com as suas dimensões
		// preferidas
		pack();
	}
	
	private /*static*/ class ConvertButtonListener implements ActionListener {

		/*
		 * Desnecessário porque a classe deixou de ser STATIC,
		 *  ou seja, tem acesso às variáveis de instância do
		 *  objecto (DogAgeFrame2) que a criou. 
		 * 
		private final JTextField txtDogAge;
		private final JTextField txtHumanAge;

		public ConvertButtonListener(JTextField txtDogAge, JTextField txtHumanAge) 
		{
			this.txtDogAge = txtDogAge;
			this.txtHumanAge = txtHumanAge;
		}
		*/

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int humanAge = new Integer(txtDogAge.getText()) * 7;
			
			txtHumanAge.setText( "" + humanAge );
			

		}
		
		
		
	}

	private class ChangeColorMouseListener extends MouseAdapter /*implements MouseListener*/ 
	{

		private Color lastColor;
		
		@Override
		public void mouseEntered(MouseEvent e) {
			lastColor = e.getComponent().getBackground();
			e.getComponent().setBackground( Color.RED );
		}

		@Override
		public void mouseExited(MouseEvent e) {
			e.getComponent().setBackground( lastColor );
		}

	}
}