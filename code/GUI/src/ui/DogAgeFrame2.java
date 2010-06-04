package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

import sun.font.FontFamily;

// Inclui os elementos necessários à conversão 
// de idade do cão para idade do Humano
public class DogAgeFrame2 extends JFrame {

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
		JLabel lblDogYear     = new JLabel("Dog Year: ");
		JTextField txtDogYear = new JTextField(" « insert dog age here » ");
		
		// Adicionar a label à janela
		container.add(lblDogYear/*, BorderLayout.WEST*/);
		container.add(txtDogYear);
		
		// Ajustar a janela à dimensão necessária para apresentar
		// todos os seus componentes filho, com as suas dimensões
		// preferidas
		pack();
	}

}