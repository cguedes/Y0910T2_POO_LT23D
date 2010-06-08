package firstSamples;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import sun.font.FontFamily;

public class DogAgeFrame1 extends JFrame {

	public DogAgeFrame1() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tiny Window 2");
		
		// Criação da label (bloco de texto)
		JLabel lblHello = new JLabel();
		lblHello.setText("Hello World, and POO STUDENTS :-)");	
		lblHello.setForeground(Color.RED);
		lblHello.setBackground(Color.YELLOW);
		lblHello.setOpaque(true);
		
		// Adicionar a label à janela
		add(lblHello);
		
		// Ajustar a janela à dimensão necessária para apresentar
		// todos os seus componentes filho, com as suas dimensões
		// preferidas
		pack();
	}

}