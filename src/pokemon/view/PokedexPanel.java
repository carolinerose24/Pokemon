package pokemon.view;
import javax.swing.*;

import pokemon.controller.PokedexController;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class PokedexPanel extends JPanel
{
	private SpringLayout appLayout;
	private PokedexController appController;

	
	private JTextField pokemonField;
	
	private JLabel label1;

	public PokedexPanel(PokedexController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();
		pokemonField = new JTextField("", 1);
		
		label1 = new JLabel ("banana");
		
		
		setUpPanel();
		setUpLayout();
		setUpListeners();
	}
	
	private void setUpPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800,600));
		this.setBackground(Color.PINK);
		
		this.add(pokemonField);

	}
	
	private void setUpLayout()
	{
		
	}
	
	private void setUpListeners()
	{
		
	}

}
