package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import sun.font.FontFamily;

public class TinyWindow2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setTitle("Tiny Window 2");
		
		// Cria��o da label (bloco de texto)
		JLabel lblHello = new JLabel();
		lblHello.setText("Hello World, and POO students :-)");	
		lblHello.setForeground(Color.RED);
		lblHello.setBackground(Color.YELLOW);
		lblHello.setOpaque(true);
		
		// Adicionar a label � janela
		window.add(lblHello);
		
		// Ajustar a janela � dimens�o necess�ria para apresentar
		// todos os seus componentes filho, com as suas dimens�es
		// preferidas
		window.pack();
		
		// Mostra a janela (�ltima chamada a m�todo)
		window.setVisible(true);
	}

}
