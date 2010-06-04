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
		
		// Criação da label (bloco de texto)
		JLabel lblHello = new JLabel();
		lblHello.setText("Hello World, and POO students :-)");	
		lblHello.setForeground(Color.RED);
		lblHello.setBackground(Color.YELLOW);
		lblHello.setOpaque(true);
		
		// Adicionar a label à janela
		window.add(lblHello);
		
		// Ajustar a janela à dimensão necessária para apresentar
		// todos os seus componentes filho, com as suas dimensões
		// preferidas
		window.pack();
		
		// Mostra a janela (última chamada a método)
		window.setVisible(true);
	}

}
